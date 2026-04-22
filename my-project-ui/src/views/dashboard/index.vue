<template>
  <div class="dashboard">
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
  padding: 5px;
}

.user-section {
  margin-bottom: 20px;
  padding: 20px;
  background: #fff;
  border-radius: 4px;
}
</style>