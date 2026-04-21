<template>
  <div class="dashboard">
    <h1>控制台</h1>
    
    <!-- 用户信息 -->
    <div class="user-section">
      <h2>用户信息</h2>
      <p>管理员 | 总部 | 超级管理员</p>
    </div>

    <!-- 访问统计 -->
    <VisitStats />
  </div>
</template>

<script>
import VisitStats from './components/VisitStats.vue'

export default {
  name: 'DashboardView',
  components: {
    VisitStats
  },
  mounted() {
    console.log('✅ Dashboard 页面加载成功')
  }
}
</script>

<style scoped>
.dashboard {
  padding: 20px;
}

.user-section {
  margin-bottom: 20px;
  padding: 20px;
  background: #fff;
  border-radius: 4px;
}
</style>