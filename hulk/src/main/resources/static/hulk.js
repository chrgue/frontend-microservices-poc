console.log("Hulk says hello");


define([], function () {

    return function initFragment (element) {
        var input = $(element).find($("input"));

        function getElements(){
            return $(element).find($("ul>li"));
        }


        $(input).change(function(event){
            var currentValue = event.currentTarget.value;
            var foo = currentValue.toLocaleLowerCase();

            var allElements = getElements();

            allElements.each(function(index, element){
                var elementText = element.innerText.toLowerCase();

                $(element).css("display", elementText.includes(foo) ? "" : "none");
            })

        })

    }
});