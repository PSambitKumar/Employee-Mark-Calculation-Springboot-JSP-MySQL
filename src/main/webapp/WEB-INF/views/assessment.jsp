<%--
  User: sambit.pradhan
  Date: 4/22/2023
  Time: 10:16 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Employee Salary Update</title>
</head>
<body>

<div class="container pt-6">
    <div class="card text-center">

        <%--        Body Part--%>
        <div class="card-body ">
            <form action="${pageContext.request.contextPath}/saveEmployeeMark" method="post" id="saveEmployeeMark">
                <h3 class="card-title">Mark Entry Form</h3>

                <c:if test="${not empty message}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </c:if>

                <div class="form">

                    <div class="card">
                        <h5 class="card-header control-label">Provide Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">

                                    <div class="col-md-3 control-label">
                                        <label for="batchId" class="form-label control-label">Select Batch</label>
                                        <select id="batchId" class="form-control" name="batchId">
                                            <option value="0" selected hidden>Select</option>
                                            <c:forEach items="${batchMasterList}" var="batch" varStatus="count">
                                                <option value="${batch.id}">${batch.batchName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-md-3 control-label">
                                        <label for="technologyId" class="form-label control-label">Select Technology</label>
                                        <select id="technologyId" class="form-control" name="technologyId" onchange="getEmployeeDetails()">
                                            <option value="0" selected hidden>Select</option>
                                            <c:forEach items="${technologyMasterList}" var="technology" varStatus="count">
                                            <option value="${technology.id}">${technology.teeechnologyName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-md-3 control-label">
                                        <label for="employeeId" class="form-label control-label">Select Employee Name </label>
                                        <select class="form-select" aria-label="Default select example" id="employeeId" name="employeeId">
                                            <option value="0">Select</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3 control-label">
                                        <label for="mark" class="form-label control-label">Enter Mark</label>
                                        <input type="text" name="mark" class="form-control" id="mark" placeholder="Enter Mark" required/>
                                    </div>
                                </div>

                                <div class="btnhold mt-3">
                                    <button type="submit" class="btn btn-primary mr-3">Submit</button>
                                    <button type="reset" class="btn btn-secondary" onclick="resetPage()">Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <form action="${pageContext.request.contextPath}/searchFilter" method="post" id="searchFilter">

                    <div class="card">
                        <h5 class="card-header control-label">Search Filter</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">

                                    <div class="col-md-3 control-label">Select Batch :
                                        <select id="searchBatchId" class="form-control" name="searchBatchId">
                                            <option value="0" selected hidden>Select</option>
                                            <c:forEach items="${batchMasterList}" var="batch" varStatus="count">
                                                <option value="${batch.id}">${batch.batchName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-md-9 control-label" style="margin-top: 40px;">
                                        <button type="submit" class="btn btn-primary mr-3">Submit</button>
                                        <button type="reset" class="btn btn-secondary" onclick="resetPage()">Reset</button>
                                        <button type="reset" class="btn btn-danger" style="height: 38px;  margin-left: 45rem;" onclick="generatePDF()">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-pdf" viewBox="0 0 16 16">
                                                <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
                                                <path d="M4.603 12.087a.81.81 0 0 1-.438-.42c-.195-.388-.13-.776.08-1.102.198-.307.526-.568.897-.787a7.68 7.68 0 0 1 1.482-.645 19.701 19.701 0 0 0 1.062-2.227 7.269 7.269 0 0 1-.43-1.295c-.086-.4-.119-.796-.046-1.136.075-.354.274-.672.65-.823.192-.077.4-.12.602-.077a.7.7 0 0 1 .477.365c.088.164.12.356.127.538.007.187-.012.395-.047.614-.084.51-.27 1.134-.52 1.794a10.954 10.954 0 0 0 .98 1.686 5.753 5.753 0 0 1 1.334.05c.364.065.734.195.96.465.12.144.193.32.2.518.007.192-.047.382-.138.563a1.04 1.04 0 0 1-.354.416.856.856 0 0 1-.51.138c-.331-.014-.654-.196-.933-.417a5.716 5.716 0 0 1-.911-.95 11.642 11.642 0 0 0-1.997.406 11.311 11.311 0 0 1-1.021 1.51c-.29.35-.608.655-.926.787a.793.793 0 0 1-.58.029zm1.379-1.901c-.166.076-.32.156-.459.238-.328.194-.541.383-.647.547-.094.145-.096.25-.04.361.01.022.02.036.026.044a.27.27 0 0 0 .035-.012c.137-.056.355-.235.635-.572a8.18 8.18 0 0 0 .45-.606zm1.64-1.33a12.647 12.647 0 0 1 1.01-.193 11.666 11.666 0 0 1-.51-.858 20.741 20.741 0 0 1-.5 1.05zm2.446.45c.15.162.296.3.435.41.24.19.407.253.498.256a.107.107 0 0 0 .07-.015.307.307 0 0 0 .094-.125.436.436 0 0 0 .059-.2.095.095 0 0 0-.026-.063c-.052-.062-.2-.152-.518-.209a3.881 3.881 0 0 0-.612-.053zM8.078 5.8a6.7 6.7 0 0 0 .2-.828c.031-.188.043-.343.038-.465a.613.613 0 0 0-.032-.198.517.517 0 0 0-.145.04c-.087.035-.158.106-.196.283-.04.192-.03.469.046.822.024.111.054.227.09.346z"/>
                                            </svg>
                                        </button>
                                    </div>
                            </div>
                        </div>


                            <div id="view">
                                <h3 class="card-title">Employee Details</h3>

                                <table class="table table-bordered" width="90%">
                                    <thead>
                                    <tr>
                                        <th>Sl.No</th>
                                        <th>Batch Name</th>
                                        <th>Batch Start Date</th>
                                        <th>Technology Name</th>
                                        <th>Employee Name</th>
                                        <th>Employee Phone</th>
                                        <th>Mark</th>
                                        <th>Grade</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${tableListDTOList}" var="table" varStatus="count">
                                        <tr>
                                            <td>${count.count}</td>
                                            <td>${table.batchName}</td>
                                            <td>${table.batchStartDate}</td>
                                            <td>${table.technologyName}</td>
                                            <td>${table.employeeName}</td>
                                            <td>${table.employeePhone}</td>
                                            <td>${table.mark}</td>
                                            <td>${table.grade}</td>
                                            <td>${table.status}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
            </form>

            <form action="${pageContext.request.contextPath}/getBatch" method="get" id="getBatch"></form>
            <form action="${pageContext.request.contextPath}/generatePDF" method="get" id="generatePDF">
                <input type="hidden" name="searchBatchId1" id="searchBatchId1">
            </form>


        </div>

        </div>
    </div>
</div>
</body>
</html>

<script>
    function getEmployeeDetails() {
        let batchId = $('#batchId').val();
        let technologyId = $('#technologyId').val();

        if (batchId == 0) {
           alert("Please Select Batch");
            return false;
        }

        $.ajax({
            url: '/getEmployeeDetails',
            type: 'GET',
            data: {
                batchId: batchId,
                technologyId: technologyId
            },
            success: function (data) {
                console.log(data);
                var s = '';
                for(var i = 0; i < data.length; i++) {
                    var id = s += '<option value="' + data[i][0]+ '">' + data[i][1] + '</option>';
                }
                $('#employeeId').html(s);

            },
            error: function (data) {
                console.log(data);
            }
        });
    }

    function resetPage() {
        $('#getBatch').submit();
    }

    function generatePDF() {
        let batchId = $('#searchBatchId').val();

        $('#searchBatchId1').val(batchId);
        $('#generatePDF').submit();
    }
</script>


