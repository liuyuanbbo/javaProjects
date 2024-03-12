<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
      <a-table
          :columns="columns"
          :data-source="ebooks"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #bodyCell="{ column,record }">
          <template v-if="column.dataIndex === 'cover'">
            <img v-if="record.cover" :src="record.cover" alt="avatar" style="width: 80px;height: 80px">
          </template>
          <template v-else-if="column.key === 'operations'">
            <a-space size="small">
              <a-button type="primary" @click="showModal(record)">编辑</a-button>
              <a-button type="primary" danger>删除</a-button>
            </a-space>
          </template>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-modal v-model:open="modalVisible" title="电子书表单" ok-text="确认" cancel-text="取消"
           :confirm-loading="confirmLoading" @ok="editEbook">
    <a-form
        :model="ebk"
        name="basic"
        :label-col="{ span: 6 }"
        :wrapper-col="{ span: 16 }"
        autocomplete="off"
    >
      <a-form-item label="封面">
        <a-input v-model:value="ebk.cover"/>
      </a-form-item>

      <a-form-item label="名称">
        <a-input v-model:value="ebk.name"/>
      </a-form-item>

      <a-form-item label="分类一">
        <a-input v-model:value="ebk.category1Id"/>
      </a-form-item>

      <a-form-item label="分类二">
        <a-input v-model:value="ebk.category2Id"/>
      </a-form-item>

      <a-form-item label="描述">
        <a-input v-model:value="ebk.description"/>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script setup lang="ts">

import {ref} from "vue";
import axios from "axios";
import {BasePageRequest} from "@/types/CommonPageReq"

const columns = [
  {
    title: '封面',
    dataIndex: 'cover'
  },
  {
    title: '名称',
    dataIndex: 'name'
  },
  {
    title: '分类一',
    dataIndex: 'category1Id',
  },
  {
    title: '分类二',
    dataIndex: 'category2Id',
  },
  {
    title: '文档数',
    dataIndex: 'docCount',
  },
  {
    title: '阅读数',
    dataIndex: 'viewCount',
  },
  {
    title: '点赞数',
    dataIndex: 'voteCount',
  },
  {
    title: '操作',
    key: 'operations'
  },
]

const ebooks = ref([])
const pagination = ref({
  current: 1,
  pageSize: 3,
  total: 0
})
const loading = ref(false)
// 是否展示模态框
const modalVisible = ref<boolean>(false)
const confirmLoading = ref<boolean>(false);

// 编辑的电子书
interface Ebook {
  id?: number
  name: string
  category1Id: number
  category2Id: number
  description: string
  cover: string
  docCount?: number
  viewCount?: number
  voteCount?: number
}

const ebk = ref<Ebook>({
  name: '',
  category1Id: 101,
  category2Id: 1001,
  description: '',
  cover: ''
})

const showModal = (record: any) => {
  modalVisible.value = true;
  ebk.value = record
};

const editEbook = () => {
  confirmLoading.value = true;
  axios.post("/ebook/insertOrUpdate", ebk.value).then(resp => {
    const isSuccess = resp.data?.code === '000000'
    if (isSuccess) {
      modalVisible.value = false;
      confirmLoading.value = false;
      // 重新加载
      handleQuery({
        pageNum: pagination.value.current,
        pageSize: pagination.value.pageSize
      })
    }
  })
};

// 数据查询
const handleQuery = (param: BasePageRequest | any) => {
  loading.value = true
  axios.get(`/ebook/list`, {
    params: {
      pageNum: param.pageNum,
      pageSize: param.pageSize
    }
  }).then(res => {
    loading.value = false
    ebooks.value = res?.data?.data?.items
    //重置分页按钮
    pagination.value.current = param.pageNum
    pagination.value.total = res?.data?.data?.total
  })
}

handleQuery({
  pageNum: 1,
  pageSize: 3
})

// 点击页码时触发
const handleTableChange = (paginationParam: any) => {
  handleQuery({
    pageNum: paginationParam.current,
    pageSize: paginationParam.pageSize
  })
}

</script>

<style scoped>

</style>