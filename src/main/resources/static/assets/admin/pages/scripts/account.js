
var table;

function RenderOptionCol(val,type,item)
{
    var opts = '';
    opts += '<a href="javascript:void(0)" class="btn-edit">修改信息</a><br/>';
    opts += '<a href="javascript:void(0)" class="btn-resetPwd">重置密码</a><br/>';
    opts += '<a href="javascript:void(0)" class="btn-delete">删除账号</a> ';
    return opts;
}

$(document).ready(function(){
    var cols = [
        // {data:'accountId',name:'sys_account_id',orderable:false,createdCell:function(cell, cellData, rowData, rowIndex, colIndex){
        //     $(cell).html("<input type='checkbox' name='checkList' value='" + cellData + "'/>")} },
        {data:'accountId',name:'sys_account_id',orderable:false,createdCell:function(cell, cellData, rowData, rowIndex, colIndex){
                $(cell).html(rowIndex+1)} },
        {data:'accountRealName',name:'sys_account_real_name',orderable:true,searchable:true,visible:true,render:function(val){
            return val} },
        {data:'accountEmail',name:'sys_account_email',orderable:true,searchable:true,render:function(val){
            return val}},
        {data:'accountTel',name:'sys_account_tel',orderable:true,searchable:true,render:function(val){
            return val}},
        {data:'accountStatus',name:'sys_account_status',orderable:false,searchable:true,render:function(val){
            if(val==1){
                return '<span class="badge badge-success">正常</span>'
            }else{
                return '<span class="badge badge-warning">锁定</span>';
            }
        }},
        {data:'','name':'',orderable:false,searchable:false,width:'120px',render:RenderOptionCol },
    ];

    var grid = new Datatable();
    grid.init({
        src: $("#data_tables"),
        dataTable: {
            "columns":cols,
            "ajax": {
                "url": "/admin/account/query",
            },
            "order": [
                [4, "desc"]
            ]
        }
    });

    table = grid.getDataTable();
    table.on('click','td',function(e){
        var rowIndex = table.cell(this).index().row;
        var rowData  = table.row(rowIndex).data();
        if($(e.target).is('.btn-edit')){
            e.stopPropagation();
            GridClickFunction_Edit(rowData);
        }else if($(e.target).is('.btn-resetPwd')){
            e.stopPropagation();
            GridClickFunction_ResetPwd(rowData);
        }else if($(e.target).is('.btn-delete')){
            e.stopPropagation();
            GridClickFunction_Delete(rowData);
        }
    });
});

function GridClickFunction_Add(){
    var url = '/admin/account/add';
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'html',
        success: function(data){
            $('#popupModel .modal-content').html(data);
            App.initSlimScroll('.scroller');
        }
    });
    $('#popupModel').modal('show');
}

function GridClickFunction_Edit(item){
    var accountId = item.accountId;
    var url = "/admin/account/edit/"+accountId;
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'html',
        success: function(data){
            $('#popupModel .modal-content').html(data);
            App.initSlimScroll('.scroller');
        }
    });
    $('#popupModel').modal('show');
}

function GridClickFunction_Delete(item){
    var accountId = item.accountId;
    WX.Confirm('确定要删除该帐号么？',function(){
        var url = "/admin/account/delete/"+accountId;
        AjaxAction({'url':url, 'method':'GET','success':function(data){
            if(data.code == 1) {
                WX.toastr({'type':'success','message':'删除成功.','onHidden':function(){
                    table.ajax.reload();
                }});
            } else {
                WX.toastr({'type':'error','message':'删除失败.'});
            }
        }});
    });
}

function GridClickFunction_ResetPwd(item){
    var accountId = item.accountId;
    var url = '/admin/account/showResetPassword/'+accountId ;
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'html',
        success: function(data){
            $('#popupModel .modal-content').html(data);
            App.initSlimScroll('.scroller');
        }
    });
    $('#popupModel').modal('show');
}
