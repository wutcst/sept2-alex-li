<template>
    <div class="Login">
        <h3>登录</h3>
        <div :class="[screenWidth > '1000' ? 'main_computer' : 'main_phone']">
            <div class="main_left">
                <div class="left_item qq">
                    <img class="" src="../assets/qq.png" mode="widthFix" />
                    <v-text>
                        qq登录
                    </v-text>
                </div>
                <div class="left_item wx">
                    <img class="" src="../assets/wx.png" mode="widthFix" />
                    <v-text class="" selectable="false" space="false" decode="false">
                        微信登录
                    </v-text>
                </div>
                <div class="left_item zfb">
                    <img class="" src="../assets/zfb.png" mode="widthFix" />
                    <v-text class="" selectable="false" space="false" decode="false">
                        支付宝登录
                    </v-text>
                </div>
            </div>
            <div :class="[screenWidth > '1000' ? 'main_middle_computer' : 'main_middle_phone']"></div>
            <div class="main_right">
                <el-input class="right_item" placeholder="用户名" v-model="username"></el-input>
                <el-input class="right_item" placeholder="密码" type="password" v-model="password"></el-input>
                <el-button class="right_item" type="primary" @click="Login">登录</el-button>
            </div>
        </div>
        <div class="bottom">
            <el-button type="text" @click="toRegister">点我注册</el-button>
            <el-button type="text" @click="toModify">忘记密码</el-button>
        </div>
    </div>
</template>
  
<script>
export default {
    name: 'Login',
    data() {
        return {
            screenWidth: '',
            username: '',
            password: ''
        };
    },
    methods: {
        toRegister() {
            this.$router.push('login/register')
        },
        toModify() {
            this.$router.push('login/modify')
        },
        Login() {
            this.axios.post("user/login?username=" + this.username + "&password=" + this.password).then(res => {
                console.log(res)
                if (res.data.flag == true) {
                    sessionStorage.setItem("user",JSON.stringify(res.data.data)) //缓存用户信息
                    this.$message.success("登录成功")
                    this.$router.push('main')
                }
                else if(res.data.flag==false){
                    this.$message.error("用户名或密码错误！")
                }
            })
        }
    },
    mounted() {
        this.screenWidth = document.body.clientWidth;
        this.screenHeight = document.body.clientHeight;
        window.onresize = () => {
            return (() => {
                this.screenWidth = document.body.clientWidth;
                this.screenHeight = document.body.clientHeight;
            })();
        };
    }

}
</script>
<style scoped>
.Login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 60px;
}

.main_computer {
    display: flex;
}

.main_phone {
    flex-direction: column;
}

.main_left {
    width: 350px;
    height: 200px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    /* background-color: pink; */
}

.left_item {
    /* background-color: pink; */
    height: 60px;
    display: flex;
    align-items: center;
    background-color: #eaeaea;
    border-radius: 20px;
    /* margin-bottom: 20px; */
}

.left_item img {
    width: 40px;
    margin: 0 10px;
    margin-left: 15px;
}

.main_middle_computer {
    width: 3px;
    margin: 0 20px;
    background-color: black;
}

.main_middle_phone {
    height: 3px;
    margin: 20px 0px;
    background-color: black;
}

.main_right {
    /* background-color: green; */
    width: 350px;
    height: 200px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.right_item {
    height: 60px;
}

.main_right /deep/ .el-input__inner {
    height: 60px;
}

.bottom {
    margin-top: 20px;
    width: 200px;
    display: flex;
    justify-content: space-between;
}
</style>
  