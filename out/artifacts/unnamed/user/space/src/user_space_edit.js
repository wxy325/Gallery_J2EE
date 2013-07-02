$(document).ready(function()
{
    $("#userEdit").addClass("active");
    $("#oldPassword").blur(checkOldPassword);
    $("#newPassword").blur(checkNewPassword);
    $("#rePassword").blur(checkRePassword);
    $("#buttonReset").click(resetLoginInfo);
    $("#buttonSubmit").click(checkAndSubmit);
});


function checkOldPassword()
{

}
function checkNewPassword()
{

}
function checkRePassword()
{

}
function resetLoginInfo()
{

}
function checkAndSubmit()
{
    var form = document.getElementById("edit_form");
    form.submit();
}