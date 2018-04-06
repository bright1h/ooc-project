package com.mapringg.bab.deserializers;

import com.google.gson.*;
import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.repositories.CustomerOrderRepository;
import com.mapringg.bab.repositories.CustomerRepository;
import com.mapringg.bab.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.Calendar;

@Component
public class CustomerDeserializer implements JsonDeserializer<CustomerOrder>{

    private final CustomerRepository customerRepository;
    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerDeserializer(CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository){this.customerRepository = customerRepository; this.customerOrderRepository = customerOrderRepository;}

    @Override
    public CustomerOrder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        String email = null;
        Customer curCustomer;

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject customer = jsonObject.getAsJsonObject("customer");
        if(customer.has("email") && customer.get("email") != JsonNull.INSTANCE) {
            email = customer.get("email").getAsString();
        }
        curCustomer = customerRepository.findByEmail(email);

        System.out.println(jsonObject);
//        java.sql.Date curDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return new CustomerOrder(
                curCustomer,
                java.sql.Date.valueOf(jsonObject.get("date").getAsString()),
                jsonObject.get("status").getAsString(),
                jsonObject.get("totalPrice").getAsInt(),
                jsonObject.get("specialRequest").getAsString()
        );
    }
}
