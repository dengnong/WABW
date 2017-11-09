/**
 * Created by 54472 on 2017/4/7.
 */

function validate_patient(inputinfo) {
    if(searchPaitent.min.value=='')
    {
        return true;
    } else if (!isAge(searchPaitent.min.value)) {
        alert("输入最小年龄不合法");
        return false;
    }

    if(searchPaitent.max.value=='')
    {
        return true;
    } else if (!isAge(searchPaitent.max.value)) {
        alert("输入最大年龄不合法");
        return false;
    }

    return true;
}

function validate_checklist(input){


}

function isAge(str) {
    var rx = /^[0-9]+$/;
    return rx.test(str);

}