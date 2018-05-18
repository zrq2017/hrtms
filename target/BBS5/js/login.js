/**
 * Created by sjf on 5/27/17.
 */
window.onload = function () {
    var submit = document.querySelector('.submit')//获取class=submit的第一个元素。，正确。
/*
 * 页面加载后调用此函数，
 * 按下登录按钮时调用submit.onclick=function（），将用户名和密码封装进一个JSON对象中，并利用AJAX向服务器发送请求
 * 传递，将（请求方式，URL,数据，以及logincb方法）传递给ajax。js中的ajax函数。
 *
 * 表单默认以Content-Type:application/x-www-form-urlencoded，传输数据。
 */

    submit.onclick = function () {
        var username = document.querySelector('.username').value
        var password = document.querySelector('.password').value

        if (username && password) {
            var loginMes = {
                action: "checklogin",
                username: username,
                password: password
            } //这是一个JS对象。JSON.stringify(js对象)：将一个JS对象变成一个JSON格式字符串。
              //使用JSON.parse(JSON格式字符串变量):变成JS对象。
              //疑问：服务器端并没有解析JSON字符串，疑个鬼！，压根就没用Ajax.js和login.js。
             //用了，还没变。猜想：表单的格式需要通过enctypee属性改变。
            ajax("POST", "user", JSON.stringify(loginMes), loginCb)//stringify：从一个对象中解析字符串。，logincb是一个方法。

        } else {
            alert("用户名和密码为必填")
        }
    }

    /*
    logincb,AJAX调用此方法处理服务器的返回数据。
     */
    function loginCb(data) { //data:实参：responseText；
        console.log(data);
        data = JSON.parse(data)//接收服务器数据(一般是字符串)并将其转换为JS对象。在这里进行页面跳转。
        console.log(data);
        if (data.hasOwnProperty("status")) {
            alert("该用户不存在，请先进行注册")
            location.href="Register.jsp"
        } else {
            location.href = "index.jsp"
            localStorage.setItem("user", JSON.stringify(data))
            
        }
    }
}