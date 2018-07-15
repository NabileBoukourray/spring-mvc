import $ from "jquery";

class Switch {

    constructor(options) {
        this.options = options;
        this.isSwitched = false;
    }

    initialize(firstOption, secondOption) {
        $(".switch-btn .firstOption").text(firstOption);
        $(".switch-btn .secondOption").text(secondOption);
        $(".switch-btn .inner").text(secondOption);
    }

    switch(firstOption, secondOption) {

        if (!this.isSwitched) {
            $(".switch-btn").toggleClass("active");
            $(".switch-btn .inner").text(firstOption);
            for (let elem of this.options) {
                this.switch_on(elem.html, elem.beforeClass);
            }
        } else if (this.isSwitched) {
            $(".switch-btn").toggleClass("active");
            $(".switch-btn .inner").text(secondOption);
            for (let elem of this.options) {
                this.switch_off(elem.classSelector);
            }
        }
    }

    switch_on(html, beforeId) {
        $(html).insertBefore("." + beforeId);
        this.isSwitched = true;
    }

    switch_off(classSelector) {
        $("." + classSelector).fadeOut("fast", () => {
            $("." + classSelector).remove();
        });
        this.isSwitched = false;
    }
}

export default Switch;
