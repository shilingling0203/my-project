import axios from 'axios'

// ✅ 确保 axios 正确导入
const service = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 5000
})

// ✅ 请求拦截器
service.interceptors.request.use(
  config => {
    const token = localStorage.getItem('token')
    if (token) {
      config.headers['Authorization'] = 'Bearer ' + token
    }
    return config
  },
  error => {
    return Promise.reject(error)
  }
)

// ✅ 响应拦截器
service.interceptors.response.use(
  response => {
    // 直接返回 data，避免嵌套
    return response.data
  },
  error => {
    console.error('请求错误:', error)
    return Promise.reject(error)
  }
)

export default service