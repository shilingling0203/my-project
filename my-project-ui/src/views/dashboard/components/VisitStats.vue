<template>
  <div class="dashboard-container">
    <!-- 右上角用户信息 -->
    <div class="user-area">
      <el-dropdown @command="handleCommand">
        <span class="user-dropdown">
          <el-avatar :size="36" :src="user.avatar" />
          <span class="username">{{ stats.userName }}</span>
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="profile">
              <i class="el-icon-user"></i> 个人中心
            </el-dropdown-item>
            <el-dropdown-item command="logout" divided>
              <i class="el-icon-switch-button"></i> 退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>

    <!-- 原有控制台内容 -->
    <div class="dashboard-content">
      <el-card class="dashboard-card">
        <div class="header">
          <!-- <el-avatar :size="48" :src="stats.avatar" /> -->
          <div class="user-info">
            <!-- <div class="username">{{ stats.userName }}</div> -->
            <div class="pv">今日访问量：{{ stats.pv }}</div>
          </div>
        </div>

        <el-divider />

        <div class="stats">
          <div>📦 订单：{{ stats.orderCount }}</div>
          <div>💰 销售额：{{ stats.salesAmount }}</div>
          <div>⚠️ 库存预警：{{ stats.stockWarning }}</div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import { getDashboardStats } from '@/api/dashboard'


export default {
  data() {
    return {
      stats: {
        pv: 0,
        userName: '',
        avatar: '',
        orderCount: 0,
        salesAmount: 0,
        stockWarning: 0
      },
      user: {
        userName: '',
        avatar: ''
      }
    }
  },
  mounted() {
    this.loadStats()
    this.loadUserInfo()
  },
  methods: {
    async loadStats() {
      try {
        const res = await getDashboardStats()
        if (res.code === 200) {
          this.stats = res.data
        }
      } catch (e) {
        console.error('加载失败', e)
      }
    },
    
    loadUserInfo() {
      const userStr = localStorage.getItem('user')
      if (userStr) {
        const user = JSON.parse(userStr)
        this.user = {
          userName: user.userName || user.realName || '用户',
          avatar: user.avatar || 'https://i.pravatar.cc/100'
        }
      }
    },
    
    handleCommand(command) {
      switch (command) {
        case 'profile':
          this.$router.push('/profile')
          break
        case 'logout':
          this.logout()
          break
      }
    },
    
    logout() {
      this.$confirm('确定要退出登录吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        localStorage.removeItem('token')
        localStorage.removeItem('user')
        this.$router.replace('/login')
    
        this.$message({
          type: 'success',
          message: '已退出登录'
        })
      }).catch(() => {})
    }
  }
}
</script>

<style scoped>
/* ✅ 白色背景 + 边距 */
.dashboard-container {
  min-height: 100vh;
  background-color: #ffffff; /* 白色背景 */
  padding: 4px; /* 边距 */
  box-sizing: border-box;
}

/* 右上角用户信息 */
.user-area {
  position: absolute;
  top: 20px;
  right: 20px;
  z-index: 1000;
}

.user-dropdown {
    display: flex;
    align-items: center;
    cursor: pointer;
    padding: 10px 30px;
    border-radius: 6px;
    transition: background-color 0.3s;
    background-color: #ffffff;
    margin-right: 20px;
}

.user-dropdown:hover {
  background-color: #e9ecef;
}

.username {
  margin-left: 8px;
  font-size: 14px;
  color: #333;
  font-weight: 500;
  margin-right: 8px;
}

.el-icon-arrow-down {
  margin-left: 5px;
  font-size: 12px;
  color: #999;
}

/* 内容区域 */
.dashboard-content {
  margin-top: 60px;
  max-width: 1200px;
  margin-left: auto;
  margin-right: auto;
}

/* 卡片样式 */
.dashboard-card {
  border-radius: 12px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
  border: 1px solid #ebeef5;
}

.header {
  display: flex;
  align-items: center;
  padding: 8px 0;
}

.user-info {
  margin-left: 16px;
}

.stats {
  display: flex;
  justify-content: space-around;
  margin-top: 20px;
  padding: 20px 0;
  background-color: #fafafa;
  border-radius: 8px;
}

.stats > div {
  text-align: center;
  font-size: 16px;
  color: #606266;
}

.stats > div::before {
  display: block;
  font-size: 24px;
  margin-bottom: 8px;
}

/* 响应式调整 */
@media (max-width: 768px) {
  .dashboard-container {
    padding: 12px;
  }
  
  .dashboard-content {
    margin-top: 80px;
  }
  
  .stats {
    flex-direction: column;
    gap: 16px;
  }
}
</style>