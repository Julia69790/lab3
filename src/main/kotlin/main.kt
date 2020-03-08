import kotlin.browser.document
import data.Student
import data.studentList
import kotlinx.html.*
import kotlinx.html.attributes.enumEncode
import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlinx.html.js.li
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLLabelElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear

var ascending = true

fun main() {
    document.getElementById("root")!!
        .append {
            h1 {
                +"Students"
                onClickFunction = onCLickFunction()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.map {
                    li {
                        +"${it.firstname} ${it.surname}"
                        attributes += "id" to it.firstname
                        onClickFunction = click(it)
                    }
                }
            }
            label{

            }
            label( colorButton = arrayListOf<String>("green","red","blue"))
        }
}

fun TagConsumer<HTMLElement>.label(classes : String? = null,
                                   colorButton:ArrayList<String>,
                                   block : LABEL.() -> Unit = {})
        : HTMLLabelElement = label(classes)
{
    colorButton.forEach {
        attributes += "value" to it
        + it
        input(InputType.radio) {
            onClickFunction = buttonColor(it)
        }
    }
    block()
}





private fun buttonColor(newColor: String): (Event) -> Unit {
    return {
        val root = document.getElementById("root")!!
        root.setAttribute("style", "color:${newColor}")
    }
}

private fun LI.click(student: Student): (Event) -> Unit {
    return {
        val presenceStudent = document.getElementById(student.firstname)!!
        if (student.absence) {
            presenceStudent.setAttribute("style", "color:black")
            student.absence = false
        }
        else {
            presenceStudent.setAttribute("style", "color:gray")
            student.absence = true
        }
    }
}


private fun H1.onCLickFunction(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname }
            ascending = !ascending
            studentList.map {
                li {
                    +"${it.firstname} ${it.surname}"
                }
            }
        }
    }
}

