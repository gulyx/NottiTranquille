<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Use JSTL core lib in order to add some useful feature --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <!-- HEADER -->
    <%@include file="header.html" %>

    <title>Notti Tranquille</title>

</head>

<body>
<!-- NAVBAR
================================================== -->
<%@include file="navbar.html" %>

<div class="container">

    <div class="bootstrap-table">
        <div class="fixed-table-toolbar">
            <div class="bars pull-left"><div id="toolbar">
                <button id="remove" class="btn btn-danger" disabled="">
                    <i class="glyphicon glyphicon-remove" ></i> Delete
                </button>
            </div>
        </div>
        <div class="columns columns-right btn-group pull-right">
            <button class="btn btn-default" type="button" name="paginationSwitch" title="Hide/Show pagination">
                <i class="glyphicon glyphicon-collapse-down icon-chevron-down"></i>
            </button>
            <button class="btn btn-default" type="button" name="refresh" title="Refresh">
                <i class="glyphicon glyphicon-refresh icon-refresh"></i>
            </button>
            <button class="btn btn-default" type="button" name="toggle" title="Toggle">
                <i class="glyphicon glyphicon-list-alt icon-list-alt"></i>
            </button>
            <div class="keep-open btn-group" title="Columns">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-th icon-th"></i>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li>
                        <label><input type="checkbox" data-field="id" value="1" checked="checked"> Item ID</label>
                    </li>
                    <li>
                        <label><input type="checkbox" data-field="name" value="2" checked="checked"> Item Name</label>
                    </li>
                    <li>
                        <label><input type="checkbox" data-field="price" value="3" checked="checked"> Item Price</label>
                    </li>
                    <li>
                        <label>
                            <input type="checkbox" data-field="operate" value="4" checked="checked"> Item Operate</label>
                    </li>
                </ul>
            </div>
            <div class="export btn-group">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">
                    <i class="glyphicon glyphicon-export icon-share"></i>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li data-type="json">
                        <a href="javascript:void(0)">JSON</a>
                    </li>
                    <li data-type="xml">
                        <a href="javascript:void(0)">XML</a>
                    </li>
                    <li data-type="csv">
                        <a href="javascript:void(0)">CSV</a>
                    </li><li data-type="txt">
                    <a href="javascript:void(0)">TXT</a>
                </li>
                    <li data-type="sql">
                        <a href="javascript:void(0)">SQL</a>
                    </li>
                    <li data-type="excel">
                        <a href="javascript:void(0)">MS-Excel</a>
                    </li>
                </ul>
            </div>
        </div>
            <div class="pull-right search">
                <input class="form-control" type="text" placeholder="Search">
            </div>
        </div>
        <div class="fixed-table-container" style="height: 264px; padding-bottom: 81px;">
            <div class="fixed-table-header" style="margin-right: 0px;">
                <table class="table table-hover" style="width: 1123px;">
                    <thead>
                    <tr>
                        <th class="detail" rowspan="2">
                            <div class="fht-cell" style="width: 30px;"></div>
                        </th>
                        <th class="bs-checkbox " style="text-align: center; vertical-align: middle; width: 36px; " rowspan="2" data-field="state" tabindex="0">
                            <div class="th-inner ">
                                <input name="btSelectAll" type="checkbox"></div>
                            <div class="fht-cell" style="width: 35px;"></div>
                        </th>
                        <th style="text-align: center; vertical-align: middle; " rowspan="2" data-field="id" tabindex="0">
                            <div class="th-inner sortable both">Item ID</div>
                            <div class="fht-cell" style="width: 220px;"></div>
                        </th>
                        <th style="text-align: center; " colspan="3" tabindex="0">
                            <div class="th-inner ">Item Detail</div>
                            <div class="fht-cell"></div>
                        </th>
                    </tr>
                    <tr>
                        <th style="text-align: center; " data-field="name" tabindex="0"><div class="th-inner sortable both">Item Name</div><div class="fht-cell" style="width: 281px;"></div></th><th style="text-align: center; " data-field="price" tabindex="0"><div class="th-inner sortable both">Item Price</div><div class="fht-cell" style="width: 277px;"></div></th><th style="text-align: center; " data-field="operate" tabindex="0"><div class="th-inner ">Item Operate</div><div class="fht-cell" style="width: 275px;"></div></th></tr></thead></table></div><div class="fixed-table-body"><div class="fixed-table-loading" style="top: 82px; display: none;">Loading, please wait...</div><table id="table" data-toolbar="#toolbar" data-search="true" data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-show-export="true" data-detail-view="true" data-detail-formatter="detailFormatter" data-minimum-count-columns="2" data-show-pagination-switch="true" data-pagination="true" data-id-field="id" data-page-list="[10, 25, 50, 100, ALL]" data-show-footer="false" data-side-pagination="server" data-url="/examples/bootstrap_table/data" data-response-handler="responseHandler" class="table table-hover" style="margin-top: -81px;">
        <thead><tr><th class="detail" rowspan="2"><div class="fht-cell"></div></th><th class="bs-checkbox " style="text-align: center; vertical-align: middle; width: 36px; " rowspan="2" data-field="state" tabindex="0"><div class="th-inner "><input name="btSelectAll" type="checkbox"></div><div class="fht-cell"></div></th><th style="text-align: center; vertical-align: middle; " rowspan="2" data-field="id" tabindex="0"><div class="th-inner sortable both">Item ID</div><div class="fht-cell"></div></th><th style="text-align: center; " colspan="3" tabindex="0"><div class="th-inner ">Item Detail</div><div class="fht-cell"></div></th></tr><tr><th style="text-align: center; " data-field="name" tabindex="0"><div class="th-inner sortable both">Item Name</div><div class="fht-cell"></div></th><th style="text-align: center; " data-field="price" tabindex="0"><div class="th-inner sortable both">Item Price</div><div class="fht-cell"></div></th><th style="text-align: center; " data-field="operate" tabindex="0"><div class="th-inner ">Item Operate</div><div class="fht-cell"></div></th></tr></thead><tbody><tr data-index="0"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="0" name="btSelectItem" type="checkbox" value="0"></td><td style="text-align: center; vertical-align: middle; ">0</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="0" data-value="Item 0" class="editable editable-click">Item 0</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="0" data-value="$0" class="editable editable-click">$0</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="1"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="1" name="btSelectItem" type="checkbox" value="1"></td><td style="text-align: center; vertical-align: middle; ">1</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="1" data-value="Item 1" class="editable editable-click">Item 1</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="1" data-value="$1" class="editable editable-click">$1</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="2"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="2" name="btSelectItem" type="checkbox" value="2"></td><td style="text-align: center; vertical-align: middle; ">2</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="2" data-value="Item 2" class="editable editable-click">Item 2</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="2" data-value="$2" class="editable editable-click">$2</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="3"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="3" name="btSelectItem" type="checkbox" value="3"></td><td style="text-align: center; vertical-align: middle; ">3</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="3" data-value="Item 3" class="editable editable-click">Item 3</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="3" data-value="$3" class="editable editable-click">$3</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="4"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="4" name="btSelectItem" type="checkbox" value="4"></td><td style="text-align: center; vertical-align: middle; ">4</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="4" data-value="Item 4" class="editable editable-click">Item 4</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="4" data-value="$4" class="editable editable-click">$4</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="5"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="5" name="btSelectItem" type="checkbox" value="5"></td><td style="text-align: center; vertical-align: middle; ">5</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="5" data-value="Item 5" class="editable editable-click">Item 5</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="5" data-value="$5" class="editable editable-click">$5</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="6"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="6" name="btSelectItem" type="checkbox" value="6"></td><td style="text-align: center; vertical-align: middle; ">6</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="6" data-value="Item 6" class="editable editable-click">Item 6</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="6" data-value="$6" class="editable editable-click">$6</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="7"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="7" name="btSelectItem" type="checkbox" value="7"></td><td style="text-align: center; vertical-align: middle; ">7</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="7" data-value="Item 7" class="editable editable-click">Item 7</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="7" data-value="$7" class="editable editable-click">$7</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="8"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="8" name="btSelectItem" type="checkbox" value="8"></td><td style="text-align: center; vertical-align: middle; ">8</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="8" data-value="Item 8" class="editable editable-click">Item 8</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="8" data-value="$8" class="editable editable-click">$8</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr><tr data-index="9"><td><a class="detail-icon" href="javascript:"><i class="glyphicon glyphicon-plus icon-plus"></i></a></td><td class="bs-checkbox"><input data-index="9" name="btSelectItem" type="checkbox" value="9"></td><td style="text-align: center; vertical-align: middle; ">9</td><td style="text-align: center; "><a href="javascript:void(0)" data-name="name" data-pk="9" data-value="Item 9" class="editable editable-click">Item 9</a></td><td style="text-align: center; "><a href="javascript:void(0)" data-name="price" data-pk="9" data-value="$9" class="editable editable-click">$9</a></td><td style="text-align: center; "><a class="like" href="javascript:void(0)" title="Like"><i class="glyphicon glyphicon-heart"></i></a>  <a class="remove" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></td></tr></tbody></table></div><div class="fixed-table-footer" style="display: none;"><table><tbody><tr></tr></tbody></table></div><div class="fixed-table-pagination" style="display: block;"><div class="pull-left pagination-detail"><span class="pagination-info">Showing 1 to 10 of 800 rows</span><span class="page-list"><span class="btn-group dropup"><button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown"><span class="page-size">10</span> <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li class="active"><a href="javascript:void(0)">10</a></li><li><a href="javascript:void(0)">25</a></li><li><a href="javascript:void(0)">50</a></li><li><a href="javascript:void(0)">100</a></li><li><a href="javascript:void(0)">All</a></li></ul></span> records per page</span></div><div class="pull-right pagination"><ul class="pagination"><li class="page-pre"><a href="javascript:void(0)">‹</a></li><li class="page-number active"><a href="javascript:void(0)">1</a></li><li class="page-number"><a href="javascript:void(0)">2</a></li><li class="page-number"><a href="javascript:void(0)">3</a></li><li class="page-number"><a href="javascript:void(0)">4</a></li><li class="page-number"><a href="javascript:void(0)">5</a></li><li class="page-last-separator disabled"><a href="javascript:void(0)">...</a></li><li class="page-last"><a href="javascript:void(0)">80</a></li><li class="page-next"><a href="javascript:void(0)">›</a></li></ul></div></div></div></div>

    <!-- FOOTER -->
    <%@include file="footer.html" %>

</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<%@include file="bootstrap_core_js.html" %>
</body>
</html>