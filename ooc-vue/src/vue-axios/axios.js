/* global localStorage */

import axios from 'axios'

const API_URL = `http://localhost:8088`

export default axios.create({
    baseURL: API_URL,
    headers: {
        'Access-Control-Allow-Origin': 'http://localhost:8080'
    }
})