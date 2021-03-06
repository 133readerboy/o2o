/**
 *
 **/
//页面加载完毕，触发该函数执行
$(function () {
    var initUrl = '/o2o/shop/getshopinitinfo';
    var registerShopUrl = '/o2o/shopadmin/registershop';
    alert(initUrl);
    //从后台获取店铺分类信息|区域信息，将其填充到页面指定区域
    getShopInitInfo();
    function getShopInitInfo() {
       $.getJSON(initUrl,function (data) {
           if (data.success) {
               var tempHtml = '';
               var tempAreaHtml = '';
               data.shopCategoryList.map(function (item,index) {
                   tempHtml += '<option data-id="'+item.shopCategoryId+'">'
                   +item.shopCategoryName+'</option>';
               });
               data.areaList.map(function (item,index) {
                   tempAreaHtml += '<option data-id = "'+item.areaId+'">'
                       +item.areaName+'</option>';
               });

               $('#shop-category').html(tempHtml);
               $('#area').html(tempAreaHtml);
           }
       }) ;
       $('#submit').click(function () {
           var shop = {};
           shop.shopName = $('#shop-name').val();
           shop.shopAddr = $('#shop-addr').val();
           shop.phone = $('#shop-phone').val();
           shop.shopDesc = $('#shop-desc').val();
           shop.shopCategory = {
               shopCategoryId : $('#shop-category').find('option').not(function () {
                    return !this.selected;
               }).data('id')
           };
           shop.area = {
               areaId : $('#area').find('option').not(function () {
                   return !this.selected;
               }).data('id')
           };
           shopImg = $('#shop-img')[0].files[0];
           var formData = new FromData();
           formData.append('shopImg',shopImg);
           formData.append('shopStr',JSON.stringify(shop));


           $.ajax({
               url : registerShopUrl,
               type : 'POST',
               data : formData,
               contentType :false,
               proceesData : false,
               cache : false,
               success:function (data) {
                   //接收后台返回值
                   if (data.success){
                       $.toast('提交成功！');
                   }else {
                       $.toast('提交失败！' + data.errMsg);
                   }

               }
           });
       });
    }
});