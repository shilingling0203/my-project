<template>
  <el-card header="快捷入口">
    <el-button @click="go('/purchase')">采购订单</el-button>
    <el-button @click="go('/sale')">销售出库</el-button>
    <el-button @click="go('/stock')">库存盘点</el-button>
  </el-card>
</template>

<script>
export default {
  methods: {
    go(path) {
      this.$router.push(path)
    }
  }
}
</script>