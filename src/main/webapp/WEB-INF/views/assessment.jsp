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
                                    <button type="reset" class="btn btn-secondary">Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>


            <div id="view">
                <h3 class="card-title">Details</h3>
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
</script>


