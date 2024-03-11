import {createApp} from 'vue'
import Antd from 'ant-design-vue';
import App from './App.vue';
import 'ant-design-vue/dist/reset.css';
import router from './router'
import store from './store'
import axios from "axios";

axios.defaults.baseURL = process.env.VUE_APP_SERVER;

createApp(App).use(store).use(router).use(Antd).mount('#app')