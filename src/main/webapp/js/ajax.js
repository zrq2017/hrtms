/**
 * create by lyh 2018.35
 * ajax函数接收（请求类型，URL,请求数据，loginCB函数）
 * 1.创建XMLHttpRequest对象
 * 2.利用XMLHttpRequest对象的open（）发出请求，并设置请求头中的content——type为application/json
 * 3.利用xhr的ononreadystatechange来关联一个函数，此函数判断是否请求成功，并接收服务器返回的数据，并将此数据传递给loginCB方法。
 * 4.将请求发送给服务器。
 * 
 */

function ajax(type, url, params, cb) {
    var xhr = new XMLHttpRequest();   //实现AJAX的对象
    xhr.open(type, "/com.lyh.BBS/" + url); //URL,Application上下文+定义的映射路劲。
    /*
    将"content-type"设置为"application/json"，那么，客户端发送的数据是什么格式，服务端返回的数据又是什么格式。
    这是约定还是转换操作。
     */
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () { //此函数触发5次，0，0-1,1-2,2-3,3-4.
        if (xhr.readyState == 4 && xhr.status == 200) { //请求完成，响应就绪，200-“OK”，返回了响应数据。
                                                        //能够有相应的页面就是响应成功。
            alert(xhr.responseText) //尝试输出一下返回信息。
            cb(xhr.responseText) //获取服务器的响应，responsetxt:字符串形式的响应数据 ，responseXml:x形ml式
            //
        }
    }
    xhr.send(params)//参数仅用于Post请求。
}

