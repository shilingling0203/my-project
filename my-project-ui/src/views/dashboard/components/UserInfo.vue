<template>
  <el-card class="user-info" shadow="hover">
    <div class="user-wrapper">
      <!-- 头像 -->
      <div class="avatar">
        <el-avatar :size="64" :src="userInfo.avatar">
          {{ userInfo.nickname ? userInfo.nickname.charAt(0) : 'U' }}
        </el-avatar>
      </div>

      <!-- 用户信息 -->
      <div class="info">
        <h3>{{ userInfo.nickname || '管理员' }}</h3>
        <p class="dept">
          <i class="el-icon-office-building"></i>
          {{ userInfo.deptName || '总部' }}
        </p>
        <p class="role">
          <i class="el-icon-user"></i>
          {{ userInfo.roleName || '超级管理员' }}
        </p>
        <p class="time">
          <i class="el-icon-time"></i>
          上次登录：{{ userInfo.lastLoginTime || '首次登录' }}
        </p>
      </div>

      <!-- 退出按钮 -->
      <div class="logout">
        <el-button type="text" @click="logout">退出登录</el-button>
      </div>
    </div>
  </el-card>
</template>

<script>
// ✅ 先不用 Vuex，避免报错
export default {
  name: 'UserInfo',
  data() {
    return {
      userInfo: {
        nickname: '管理员',
        deptName: '总部',
        roleName: '超级管理员',
        avatar: '',
        lastLoginTime: '2024-01-15 14:30:22'
      }
    }
  },
  methods: {
    logout() {
      this.$confirm('确定要退出登录吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        localStorage.removeItem('token')
        this.$router.push('/login')
      }).catch(() => {})
    }
  }
}
</script>

<style scoped>
.user-wrapper {
  display: flex;
  align-items: center;
}

.avatar {
  margin-right: 20px;
}

.info h3 {
  margin: 0 0 8px 0;
  font-size: 18px;
}

.info p {
  margin: 4px 0;
  color: #666;
  font-size: 13px;
}

.logout {
  margin-left: auto;
}
</style>