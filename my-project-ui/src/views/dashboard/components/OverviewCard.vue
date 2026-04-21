<template>
  <el-row :gutter="20">
    <el-col :span="6" v-for="(val, key) in data" :key="key">
      <el-card shadow="hover">
        <div>{{ format(key) }}</div>
        <h2>{{ val }}</h2>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
export default {
  props: ['data'],
  methods: {
    format(key) {
      const map = {
        orderToday: '今日订单',
        salesMonth: '本月销售额',
        stockWarning: '库存预警',
        todoCount: '待办任务',
        onlineCount: '在线人数'
      }
      return map[key] || key
    }
  }
}
</script>