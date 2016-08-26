<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    /** script for getting pictures content dynamically*/
    $(document).ready(function () {
        $.get('/MainPicturesSetter',
                function (resp) {
                //  console.log(resp);
                    function checkFlag() {
                        var userName = '<%= request.getSession().getAttribute("picturesArray") %>';
                        if (userName == 'null') {
                            $('#pictureDiv').css('background-image', "url(/img/big/SNOWSPORTS.jpg)");
                            window.setTimeout($('#picMain').load('/includes/default.jsp'), 100);
                            /** this checks the flag every 100 milliseconds*/
                        } else {
                            var array = getArray();
                            animation(array);
                        }
                    }

                    checkFlag();
                })
                .fail(function () {
                    alert("Pictures Request failed.");
                });
    });

    function getArray() {
        var array = [];
        var index = 0;
        <c:forEach var="picture" items="${picturesArray}">
        array[index] = '${picture}';
        index++;
        </c:forEach>
        return array;
    }
    function animation(array) {
        var text = array;
       // console.log(text);
        var currentBackground = -1;
        var pictureDiv = $('#pictureDiv');

        function changeBackground() {
            currentBackground = ( currentBackground + 1 ) % text.length;

            pictureDiv.fadeOut(300, function () {
                pictureDiv.css('background-image', "url(/img/big/" + text[currentBackground] + ".jpg)");
                pictureDiv.fadeIn(300);
            });
            var textDiv = $('#text');
            textDiv.fadeOut(400, function () {
                textDiv.text(text[currentBackground]);
                textDiv.fadeIn(800);
            });
            setTimeout(changeBackground, 10000);
        }

        $(document).ready(function () {
            if (text.length > 0) {
                setTimeout(changeBackground, 0);
            }
            else {
                pictureDiv.css('background-image', "url(/img/big/SNOWSPORTS.jpg)");
            }
        });
    }
</script>

<section id="main">
    <div class="containerDefaultPictures">
        <div class="page-container-full page-container-no-padding">
            <div class="row" style="margin: 0">
                <div class="col-lg-12 col-md-12" style="padding: 0">
                    <div class="div-img change-img" id="pictureDiv">
                        <div class="text-center paddingTop10">
                            <h5><strong class="white" id="text"></strong></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

