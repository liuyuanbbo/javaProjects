import {createApp} from 'vue'
import Antd from 'ant-design-vue';
import App from './App.vue';
import 'ant-design-vue/dist/reset.css';
import router from './router'
import store from './store'
import axios from "axios";

axios.defaults.baseURL = process.env.VUE_APP_SERVER;

axios.interceptors.request.use(function (config) {
    console.log("请求参数: ", config)
    return config
}, error => {
    return Promise.reject(error)
})

axios.interceptors.response.use(function (res) {
    console.log("返回结果: ", res)
    return res
}, error => {
    return Promise.reject(error)
})

createApp(App).use(store).use(router).use(Antd).mount('#app')