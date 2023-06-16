<template>
    <div class="container">
        <!-- <div class="title">巨洞冒险游戏</div> -->
        <div class="game">
            <img class="player" src="http://1.13.173.161:8080/images/wanjia.png" alt="">
            <img class="back" src="http://1.13.173.161:8080/images/fanhui.png" @click="back" alt="">
            <v-text class="currentRoom">当前房间号：{{ currentRoomId }}</v-text>
            <img class="shang" src="../assets/shang.png" alt="" @click="toNorth">
            <img class="xia" src="../assets/xia.png" alt="" @click="toSouth">
            <!-- <img class="zuo" src="../assets/zuo.png" alt="" @click="toWest"> -->
            <img class="you" src="../assets/you.png" alt="" @click="toEast">
            <!-- <div class="monster">
                <img src="../assets/monster2.png" alt="">
            </div> -->
            <div class="monster">
                <div v-for="(item, index) in monster">
                <el-popover placement="top-start" title="怪兽信息" trigger="hover" width="200">
                    <div class="item_top">
                        <v-text> 名字：{{ item.name }} </v-text>
                        <v-text>描述：{{ item.des }}</v-text>
                        <v-text> 战斗力：{{ item.value }} </v-text>
                        <el-button type="danger" @click="beatMonster(index)">战斗</el-button>
                    </div>
                    <div slot="reference" class="monsterItem">
                        <img class="monsterImg" :src="item.img" alt="">
                    </div>
                </el-popover>
            </div>
            </div>
            

            <!-- <div class="title">巨洞冒险游戏</div> -->
            <div class="options">
                <div class="buttons" @click="getPlayerItem"> <img src="http://1.13.173.161:8080/images/quest_icon_02.png"
                        mode="heightFix" alt=""> <v-text>个人背包</v-text></div>
                <div class="buttons" @click="getRoomItem"> <img src="http://1.13.173.161:8080/images/icon_save.png"
                        mode="widthFix" alt=""><v-text>查看房间</v-text></div>
                        <div class="buttons" @click="goMain"> <img src="http://1.13.173.161:8080/images/refresh_de.png"
                        mode="widthFix" alt=""><v-text>返回首页</v-text></div>
                <!-- <div class="buttons" @click="getPlayerItem"> <img src="http://1.13.173.161:8080/images/icon_80.png" mode="widthFix" alt=""><v-text>挑战怪兽</v-text></div> -->
            </div>
        </div>
        <!-- 个人背包 -->
        <div class="dialog_diy1">
            <el-dialog title="个人背包" :visible.sync="dialogVisible1" width="30%" top="250px" :before-close="handleClose">
                <div class="tiliDiv">
                    <v-text>体力值：{{ player.value }}</v-text>
                    <img class="tili" src="http://1.13.173.161:8080/images/S_Holy01.png" alt="">
                </div>
                <div class="items">
                    <div v-for="(item, index) in playerItem">
                        <!-- <img src="http://qiniuyun.zhihuiguliao.com/QQ20230413-1.jpg" alt=""> -->
                        <el-popover placement="top-start" title="物品描述" trigger="hover" width="200">
                            <div class="item_top">
                                <v-text>{{ item.des }}</v-text>
                                <el-button type="danger" @click="dropItem(index)">丢弃</el-button>
                            </div>
                            <div slot="reference" class="item">
                                <img :src="item.img" mode="widthFix" alt="">
                                <v-text> 名称：{{ item.name }} </v-text>
                                <v-text> 属性值：{{ item.value }} </v-text>
                            </div>
                        </el-popover>
                    </div>
                </div>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible1 = false">取 消</el-button>
                    <el-button type="primary" @click="dialogVisible1 = false">确 定</el-button>
                </span>
            </el-dialog>
        </div>
        <!-- 房间物品 -->
        <div class="dialog_diy1">
            <el-dialog title="房间物品" :visible.sync="dialogVisible2" width="30%" top="250px" :before-close="handleClose">
                <div class="items">
                    <div v-for="(item, index) in roomItem">
                        <el-popover placement="top-start" title="物品描述" trigger="hover" width="200">
                            <div class="item_top">
                                <v-text>{{ item.des }}</v-text>
                                <el-button type="primary" @click="takeItem(index)">捡起</el-button>
                            </div>
                            <div slot="reference" class="item">
                                <img :src="item.img" mode="widthFix" alt="">
                                <v-text> 名称：{{ item.name }} </v-text>
                                <v-text> 属性值：{{ item.value }} </v-text>
                            </div>
                        </el-popover>
                    </div>
                </div>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible2 = false">取 消</el-button>
                    <el-button type="primary" @click="dialogVisible2 = false">确 定</el-button>
                </span>
            </el-dialog>
        </div>
    </div>

    <!-- <img class="" src="../assets/cave.png" mode="widthFix" lazy-load="false" binderror="" bindload="">
		</img> -->
</div></template>

<script>
export default {
    name: 'HelloWorld',
    props: {
        msg: String
    },
    data() {
        return {
            playerItem: [],
            currentRoomId: '',
            roomItem: [],
            player:[],
            dialogVisible1: false,
            dialogVisible2: false,
            monster: []
        }
    },
    mounted() {
        this.getInfo()
    },
    methods: {
        goMain(){
            this.$router.push({
                path:'/main'
            })
        },
        getInfo() {
            console.log(this.$route.query)
            this.currentRoomId = this.$route.query.currentRoomId
            this.axios.get("room/roomId=" + this.currentRoomId).then(res => {
                console.log(res.data.data)
                // this.roomItem = res.data.data
            })
            this.axios.get("monster/roomId=" + this.currentRoomId).then(res => {
                console.log("sssssssssss")
                this.monster = res.data.data
                console.log(this.monster)
            })
            this.axios.get("player").then(res=>{
                this.player = res.data.data[0]
            })
            let player = {
                "id":1,
                "currentRoom":this.currentRoomId
            }
            this.axios.put("player/update",player).then(res=>{
                console.log(res)
            })
            // this.axios.get("article/uid=" + this.uid).then(res => {
            //     console.log(res)
            //     this.tableData = res.data.data
            // })
        },
        getPlayerItem() {
            this.axios.get("player").then(res=>{
                this.player = res.data.data[0]
            })
            this.axios.get("item/roomId=0").then(res => {
                console.log(res.data.data)
                this.playerItem = res.data.data
            }).then(
                this.dialogVisible1 = true
            )
        },
        getRoomItem() {
            this.axios.get("item/roomId=" + this.currentRoomId).then(res => {
                console.log(res)
                this.roomItem = res.data.data
            }).then(
                this.dialogVisible2 = true
            )
        },
        dropItem(index) {
            console.log(index)
            var value = this.player.value-this.playerItem[index].value
            let player = {
                "id":1,
                "value":value
            }
            this.axios.put("player/update",player).then(res=>{
                this.player.value = value
            })

            let dropItem = {
                "id": this.playerItem[index].id,
                "roomId": this.currentRoomId
            }
            this.axios.put("item/update", dropItem).then(res => {
                console.log(res)
                this.$alert("丢弃成功！", "提示", {
                    callback: action => {
                        this.dialogVisible1 = false
                    }
                })
            })
        },
        takeItem(index) {
            var value = this.player.value+this.roomItem[index].value
            let player = {
                "id":1,
                "value":value
            }
            this.axios.put("player/update",player).then(res=>{
                this.player.value = value
            })
            let takeItem = {
                "id": this.roomItem[index].id,
                "roomId": 0
            }
            this.axios.put("item/update", takeItem).then(res => {
                console.log(res)
                this.$alert("捡起成功！", "提示", {
                    callback: action => {
                        this.dialogVisible2 = false
                    }
                })
            })
        },
        beatMonster(index){
            let beatMonster = {
                "id":this.monster[index].id,
                "roomId":0
            }
            if((this.player.value>this.monster[0].value)||(this.player.value==this.monster[0].value)){
                this.axios.put("monster/update", beatMonster).then(res => {
                console.log(res)
                this.$alert("打败成功！", "提示", {
                    callback: action => {
                        this.getInfo()
                        // this.dialogVisible2 = false
                    }
                })
            })
            }
            else{
                this.$alert("当前战斗力不足，战斗失败！", "提示", {
                    callback: action => {
                        // this.getInfo()
                        // this.dialogVisible2 = false
                    }
                })
            }
            
        },
        toEast() {
            if(this.monster.length==0){
                this.$router.push({
                path: '/room5',
                query: {
                    currentRoomId: 5
                }
            })
            }
            else{
                this.$alert("当前房间内存在怪兽，请先打败他们！", "提示")
            }
        },
        toSouth() {
            if(this.monster.length==0){
                this.$router.push({
                path: '/room1',
                query: {
                    currentRoomId: 1
                }
            })
            }
            else{
                this.$alert("当前房间内存在怪兽，请先打败他们！", "提示")
            }
        },
        toNorth() {
            if(this.monster.length==0){
                this.$router.push({
                path: '/room7',
                query: {
                    currentRoomId: 7
                }
            })
            }
            else{
                this.$alert("当前房间内存在怪兽，请先打败他们！", "提示")
            }
        },
        back(){
            this.$router.go(-1)
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container {
    padding-bottom: 20px;
    height: 650px;
    display: flex;
    justify-content: center;
    align-items: center;

}
.player{
    width: 200px;
    position: absolute;
    top: 200px;
    left: 300px;
}
.currentRoom{
    position: absolute;
    right: 10px;
    top: 10px;
    color: white;
}
.back{
    width: 70px;
    position: absolute;
    left: 20px;
    top: 10px;
}
.back:hover{
    cursor: pointer;
}

.game {
    background: url("http://1.13.173.161:8080/images/wuzi.jpg");
    z-index: 0;
    background-size: cover;
    width: 1000px;
    height: 600px;
    position: relative;
}

img {
    width: 1100px;
}

.shang {
    position: absolute;
    top: -10px;
    width: 120px;
    left: 0;
    right: 0;
    margin: auto;
    z-index: 1;
}

.xia {
    position: absolute;
    bottom: -10px;
    left: 0;
    right: 0;
    margin: auto;
    width: 120px;
    z-index: 1;
}

.zuo {
    position: absolute;
    left: -10px;
    top: 0;
    bottom: 0;
    margin: auto 0;
    text-align: center;
    width: 120px;
    z-index: 1;
}

.you {
    position: absolute;
    right: -10px;
    top: 0;
    bottom: 0;
    margin: auto 0;
    width: 120px;
    z-index: 1;
}

.title {
    position: absolute;
    color: white;
    top: 40px;
    left: 0;
    font-size: 40px;
    right: 0;
    text-align: center;
    margin: auto;
}

.buttons {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}


.buttons img:hover {
    /* color: white; */
    /* background-color: black; */
    transition: all 0.4s;
    /* transform: translateY(-15px); */
    cursor: pointer;
    transform: scale(1.2);
}

.options {
    position: absolute;
    padding: 10px 0;
    width: 350px;
    background-color: white;
    display: flex;
    justify-content: space-around;
    right: 30px;
    bottom: 30px;
    border-radius: 20px;
    /* opacity: 0.2; */
}
.buttons img {
    height: 40px;
    width: auto;
    margin-bottom: 2px;
    /* opacity: 0.1; */
    /* border-radius: 35px; */
}

.monster {
    position: absolute;
    /* width: 200px; */
    top: 230px;
    left: 580px;
}
.monster img{
    width: 120px;
}


.monster:hover {
    cursor: pointer;
    transition: 0.3s;
    transform: scale(1.2);
}

img {
    /* width: 150px; */
    /* border: solid black; */
}

/* 个人背包 */
.items {
    display: flex;
}

.item {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-right: 20px;
}

.item img {
    width: 80px;
    margin-bottom: 5px;
}

.item v-text {
    margin-top: 5px;
}

.item_top {
    display: flex;
    flex-direction: column;
}

.item_top .el-button {
    margin-top: 10px;
    /* width: 20px; */
}

/* 体力值 */
.tiliDiv{
    /* height: 100px; */
    display: flex;
    justify-content: flex-end;
    /* justify-content: center; */
    align-items: center;
    margin-bottom: 5px;
}
.tiliDiv img{
    width: 15px;
    height: 15px;
    margin-left: 10px;
    margin-right: 10px;
    /* margin-bottom: 5px; */
}
.el-dialog__body{
    padding: 0;
}

	.el-dialog__wrapper {
		.el-dialog__body {
			/* background-color: blue; */
            padding: 0 20px;
		}
	}

</style>
