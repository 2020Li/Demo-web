const e = React.createElement; // 简化代码
// LikeButton是一个React类组件
function LikeButton() {

    const options={
        style:{
            width:"70px",
            height:"35px",
            borderRadius:"5px",
            backgroundColor:"#34D1FF",

        },
        type:{
          button:"button",
        },

        onClick: function () {
           // const btn=document.querySelector("button");
            const email=document.getElementById("query_email");
            const  pwd=document.getElementById("query_pwd");
           // alert(email.value+pwd.value);
            fetch('http://localhost:8080/Demo_web/user/userLogin', {
                method: 'post',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body:'email='+email.value+'&pwd='+pwd.value,

            }).then(response => response.text()).then(data => {
               // alert(data)
               // console.log(data);
                if(data != "lose" && data != "null"){
                    window.location.href="/Demo_web/user/index?userId="+data;
                }else {
                    if (data == "null"){
                        alert("邮箱或密码不能为空！")
                    } else {
                    alert("邮箱或密码错误！");}
                }
            });

        },
    };
    return e('button',options,'登录');
}

/*const domContainer = document.querySelector('#example');*/
ReactDOM.render(e(LikeButton),document.getElementById('login'));
