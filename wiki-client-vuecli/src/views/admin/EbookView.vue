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
              <a-button type="primary">编辑</a-button>
              <a-button type="primary" danger>删除</a-button>
            </a-space>
          </template>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
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

// 数据查询
const handleQuery = (param: BasePageRequest | any) => {
  loading.value = true
  axios.get("/ebook/list", param).then(res => {
    loading.value = false
    ebooks.value = res?.data?.data
    //重置分页按钮
    pagination.value.current = param.page
  })
}

handleQuery({})

// 点击页码时触发
const handleTableChange = () => {
  handleQuery({
    page: pagination.value.current,
    size: pagination.value.pageSize
  })
}

</script>

<style scoped>

</style>