<template>
	<div class="container">
		<div class="game">
			<div class="title">巨洞冒险游戏</div>
			<div class="options">
				<div class="buttons" @click="newGame">新的开始</div>
				<div class="buttons" @click="goOnGame">继续游戏</div>
				<div class="buttons" @click="dialogVisible = true">查看帮助</div>
			</div>
		</div>
		<!-- <img class="" src="../assets/cave.png" mode="widthFix" lazy-load="false" binderror="" bindload="">
		</img> -->
		<div class="dialog_diy">
			<el-dialog title="游戏帮助" :visible.sync="dialogVisible" width="30%" top="250px" :before-close="handleClose">
				<span>本游戏为巨洞探险,请捡起装备打败怪兽完成通关吧！</span>
				<span slot="footer" class="dialog-footer">
					<el-button @click="dialogVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogVisible = false">确 定</el-button>
				</span>
			</el-dialog>
		</div>

	</div>
</template>

<script>
export default {
	name: 'HelloWorld',
	props: {
		msg: String
	},
	data() {
		return {
			dialogVisible: false
		}
	},
	methods: {
		newGame() {
			let player = {
				"id": 1,
				"value": 0
			}
			this.axios.put("player/update", player)
			let item1 = {
				"id": 1,
				"roomId": 1
			}
			this.axios.put("item/update", item1)
			let item2 = {
				"id": 2,
				"roomId": 2
			}
			this.axios.put("item/update", item2)
			let item3 = {
				"id": 3,
				"roomId": 2
			}
			this.axios.put("item/update", item3)
			let item4 = {
				"id": 4,
				"roomId": 3
			}
			this.axios.put("item/update", item4)
			let item5 = {
				"id": 5,
				"roomId": 5
			}
			this.axios.put("item/update", item5)
			let item6 = {
				"id": 6,
				"roomId": 5
			}
			this.axios.put("item/update", item6)
			let item7 = {
				"id": 7,
				"roomId": 8
			}
			this.axios.put("item/update", item7)
			let item8 = {
				"id": 8,
				"roomId": 4
			}
			this.axios.put("item/update", item8)
			let monster1 = {
				"id": 1,
				"roomId": 9
			}
			this.axios.put("monster/update", monster1)
			let monster2 = {
				"id": 2,
				"roomId": 1
			}
			this.axios.put("monster/update", monster2)
			let monster3 = {
				"id": 3,
				"roomId": 2
			}
			this.axios.put("monster/update", monster3)
			let monster4 = {
				"id": 5,
				"roomId": 4
			}
			this.axios.put("monster/update", monster4)
			let monster5 = {
				"id": 6,
				"roomId": 6
			}
			this.axios.put("monster/update", monster5).then(
				this.$router.push({
				path: '/room1',
				query: {
					currentRoomId: 1
				}
			})
			)
		},
		goOnGame(){
			console.log("sss")
			this.axios.get("player").then(res=>{
                this.player = res.data.data[0]
				// console.log(this.player.currentRoomId)
				this.$router.push({
					path:'/room'+this.player.currentRoom,
					query:{
						currentRoomId:this.player.currentRoom
					}
				})
            })
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

.game {
	background: url("../assets/cave.png");
	background-size: cover;
	width: 1000px;
	height: 600px;
	position: relative;
}

img {
	width: 1100px;
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
	width: 150px;
	height: 70px;
	color: black;
	background-color: white;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 20px;
	margin: 30px 0;
}

.buttons:hover {
	/* color: white; */
	/* background-color: black; */
	/* width: 200px; */
	transition: all 0.4s;
	/* transform: translateY(-15px); */
	transform: scale(1.1);
	cursor: pointer;
}

.options {
	position: absolute;
	right: 60px;
	bottom: 30px;
}

/* .el-dialog__body {
	background-color: aqua;
} */

/* .dialog_diy {
	.el-dialog__wrapper {
		.el-dialog__header {
			background-color: red;
		}

		.el-dialog__body {
			background-color: blue;
		}

		.el-dialog__footer {
			background-color: red;
		}
	}
} */

.el-dialog {
	background-color: aquamarine;
}
</style>
