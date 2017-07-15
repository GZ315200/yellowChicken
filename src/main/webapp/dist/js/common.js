/**
 * Created by Administrator on 2017/7/11.
 */


function userlogOut() {
    $.ajax({
        type:"POST",
        url: "/org/loginOut",
        async: false,
        success:function () {
          location.href="login.html"
        }
    })
    location.href="login.html"
}