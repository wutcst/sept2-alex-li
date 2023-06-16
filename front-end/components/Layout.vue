<template>
    <div class="main">
        <el-container>
            <el-header :class="background='background1'">
                    <v-text >巨洞冒险游戏</v-text>
            </el-header>
            <el-container>
                <div :class="[background == true ? 'content' : 'content2']"><router-view></router-view></div>
            </el-container>
        </el-container>
    </div>
</template>
  
<script>
export default {
    name: 'Layout',
    data() {
        return {
            username: 'sss',
            showMenu: true,
            background: false,
            backgroundColor: '#545c64',
            activeTextColor: '#ffd04b'
        };
    },
    methods: {
        clickMenu() {
            this.showMenu = !this.showMenu
            console.log(this.showMenu)
        },

    },
    mounted() {
        this.screenWidth = document.body.clientWidth;
        this.screenHeight = document.body.clientHeight;
        window.onresize = () => {
            return (() => {
                this.screenWidth = document.body.clientWidth;
                this.screenHeight = document.body.clientHeight;
                if (this.screenWidth < 650) this.showMenu = false
                else this.showMenu = true
            })();
        };
        var username = JSON.parse(sessionStorage.getItem("user")).username
        this.username = username
    }

}
</script>
<style scoped>
.background1 {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #545c64;
    color: white;
}




.icon:hover {
    background-color: #ecf5ff;
    color: #409EFF;
}

a {
    text-decoration: none;
}

.router-link-active {
    text-decoration: none;
}


.span_color {
    color: white;
}

.content {
    padding: 1%;
    width: 98%;
}

.content2 {
    padding: 1%;
    width: 98%;
    /* height: 100%; */
    background-color: #eaeaea;
}

.el-switch {
    margin-right: 30px;
}
</style>
  