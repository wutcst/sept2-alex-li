<template>
	<div>
		<el-tabs type="border-card">
			<el-tab-pane label="个人资料">
				<el-form :model="ruleForm1" status-icon :rules="rules" ref="ruleForm1" label-width="100px"
					class="demo-ruleForm">
					<el-form-item label="用户名" prop="username">
						<el-input type="text" v-model="ruleForm1.username" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="电子邮箱" prop="mail">
						<el-input type="text" v-model.number="ruleForm1.mail" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="出生日期" prop="birthday">
						<div class="block">
							<el-date-picker v-model="ruleForm1.birthday" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
							</el-date-picker>
						</div>
					</el-form-item>
				</el-form>
				<div class="buttons">
					<el-button type="primary" @click="commitModify('ruleForm1')">提交</el-button>
				</div>
			</el-tab-pane>
			<el-tab-pane label="密码修改">
				<el-form :model="ruleForm2" status-icon :rules="rules" ref="ruleForm2" label-width="100px"
					class="demo-ruleForm">
					<el-form-item label="原始密码" prop="pass1">
						<el-input v-model="ruleForm2.pass1"></el-input>
					</el-form-item>
					<el-form-item label="新密码" prop="pass2">
						<el-input type="password" v-model="ruleForm2.pass2" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="确认密码" prop="checkPass">
						<el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off"></el-input>
					</el-form-item>
				</el-form>
				<div class="buttons">
					<el-button type="primary" @click="commitReset('ruleForm2')">提交</el-button>
					<!-- <el-button @click="resetForm('ruleForm')">重置</el-button> -->
				</div>
			</el-tab-pane>
		</el-tabs>
	</div>
</template>
<script>
export default {
	name: 'HelloWorld',
	data() {
		const checkMail = (rule, value, callback) => {
			const mailReg = /^\w+@[a-z0-9]+\.[a-z]{2,4}$/
			if (!value) {
				return callback(new Error('邮箱不能为空'))
			}
			if (mailReg.test(value)) {
				callback()
			} else {
				callback(new Error('请输入正确的邮箱格式'))
			}
		};
		var checkUsername = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入用户名'));
			} else {
				callback();
			}
		};
		var checkPass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入密码'));
			} else {
				callback();
			}
		};
		var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm2.pass2) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
		var checkDate = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请选择日期'));
			} else {
				callback();
			}
		};
		return {
			ruleForm1: {
				username: '',
				password: '',
				birthday: '',
				mail: ''
			},
			ruleForm2: {
				pass1:'',
				pass2:'',
				birthday:'',
				mail:''
			},
			rules: {
				pass1: [
					{ validator: checkPass, trigger: 'blur' }
				],
				pass2: [
					{ validator: checkPass, trigger: 'blur' }
				],
				username: [
					{ validator: checkUsername, trigger: 'blur' }
				],
				mail: [
					{ validator: checkMail, trigger: 'blur' }
				],
				birthday: [
					{ validator: checkDate, trigger: 'blur' }
				],
				checkPass: [
                    { validator: validatePass2, trigger: 'blur' }
                ]
			}
		};
	},
	mounted() {
        console.log("加载成功")
        this.getInfo()
    },
	methods: {
        getInfo() {
			var user = JSON.parse(sessionStorage.getItem("user"))
			this.ruleForm1.username = user.username
			this.ruleForm1.mail = user.mail
			this.ruleForm1.birthday = user.birthday
        },
		commitModify(formName){
			console.log(JSON.parse(sessionStorage.getItem("user")).username) //缓存用户信息
			var user = JSON.parse(sessionStorage.getItem("user"))
			console.log(user)
			console.log(this.ruleForm1.birthday)
			let data = {
				"id":user.id,
				"username":this.ruleForm1.username,
				"mail":this.ruleForm1.mail,
				"birthday":this.ruleForm1.birthday,
				"password":user.password
			}
			this.$refs[formName].validate((valid) => {
                // console.log(this.username)
                if (valid) {
                    this.axios.put("user/modify",data).then(res => {
                    console.log(res)
                    if (res.data.flag == true) {
                        alert('修改成功!');
                        this.$router.push('/login')
                    }
                    else if (res.data.flag == false) {
                        this.$message.error("原始密码错误！")
                    }
                })
                } else {
                    return false;
                }
            });
		},
		commitReset(formName){
			console.log(JSON.parse(sessionStorage.getItem("user")).username) //缓存用户信息
			var username = JSON.parse(sessionStorage.getItem("user")).username
			this.$refs[formName].validate((valid) => {
                // console.log(this.username)
                if (valid) {
                    this.axios.put("user/reset?username=" + username + "&pass1=" + this.ruleForm2.pass1+"&pass2="+this.ruleForm2.pass2).then(res => {
                    console.log(res)
                    if (res.data.flag == true) {
                        alert('修改成功!');
                        this.$router.push('/login')
                    }
                    else if (res.data.flag == false) {
                        this.$message.error("原始密码错误！")
                    }
                })
                } else {
                    return false;
                }
            });
		}
    },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-input{
	width: 300px;
}
.buttons .el-button{
	margin-left: 100px;
	width: 100px;
}
</style>
