import axios from "axios";

axios.defaults.baseURL='http://localhost:8081'

axios.interceptors.response.use(
    res=>res.data
)