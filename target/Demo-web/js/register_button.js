
const e = React.createElement; // 简化代码
// LikeButton是一个React类组件
function LikeButton() {

    const options={
        style:{
            width:"100px",
            height:"40px",
            borderRadius:"10px",
        },
        type:{
          button:"button",
        },

        onClick: function () {
           // const btn=document.querySelector("button");
            let regName=/^[\u4e00-\u9fa5]{2,10}$/;
            let regCall=/^1[3456789]\d{9}$/;
            let regEmail=/^\w{3,12}@\w{1,5}\.[a-z]{2,3}$/;
            const pwd1=document.getElementById("add_pwd");
            const  pwd2=document.getElementById("add_pwd2");
           // alert(pwd2.value);
            if (regName.test(document.getElementById("add_name").value)) {
                if(pwd1.value != "" || pwd2.value != ""){
            if (pwd1.value == pwd2.value){
                if(regCall.test(document.getElementById("add_call").value)){
                    if(regEmail.test(document.getElementById("add_email").value)){
                        fetch('http://localhost:8080/Demo_web/user/addUser',{
                            method: 'post',
                            headers: {
                                'Content-Type': 'application/x-www-form-urlencoded'
                            },
                            body:'userName='+document.getElementById("add_name").value
                            +"&password="+pwd2.value
                            +"&cellphone="+document.getElementById("add_call").value
                            +"&email="+document.getElementById("add_email").value,
                        }).then(res => res.text()).then(data => {
                            //alert(data);
                            console.log(data);
                            if (data == "login"){
                                window.location.href="/Demo_web/user/login";
                            } else if (data == "exist") {
                                alert("该邮箱已被注册！")
                            }else {
                                alert("该用户已注册！")
                            }
                        })
                    }else {
                        alert("邮箱格式不正确！")
                    }
                }else {
                    alert("手机号格式不正确！")
                }
            }else {
                alert("两次密码不一致，请重新输入！");
                }
                }else {
                    alert("请设置登录密码！")
                }
            }
                else {
                alert("用户名格式不正确！")
            }

        },
    };
    return e('button',options,'注册');
}

/*const domContainer = document.querySelector('#example');*/
ReactDOM.render(e(LikeButton),document.getElementById('registerSubmit'));
