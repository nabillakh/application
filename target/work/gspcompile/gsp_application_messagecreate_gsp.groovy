import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_messagecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/message/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('message','g',8,['code':("kanban.nomKanban.label"),'default':("Nom du projet")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("nomKanban"),'value':(kanbanInstance?.nomKanban),'class':("span12"),'id':("name")],-1)
printHtmlPart(3)
invokeTag('message','g',17,['code':("kanban.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("description"),'value':(kanbanInstance?.description),'class':("span12")],-1)
printHtmlPart(4)
invokeTag('message','g',25,['code':("kanban.famille.label"),'default':("Famille de projet")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['id':("famille"),'name':("famille.id"),'from':(application.PP.Famille.list()),'optionKey':("id"),'required':(""),'value':(kanbanInstance?.famille?.id),'class':("span12")],-1)
printHtmlPart(6)
expressionOut.print(kanbanInstance?.dateFinPlanifie)
printHtmlPart(7)
invokeTag('message','g',37,['code':("kanban.dateFinPlanifie.label"),'default':("Date de fin prévisionnelle")],-1)
printHtmlPart(8)
expressionOut.print(kanbanInstance?.dateFinPlanifie)
printHtmlPart(9)
invokeTag('message','g',50,['code':("kanban.charge.label"),'default':("Charge planifiée")],-1)
printHtmlPart(2)
invokeTag('textField','g',52,['name':("charge"),'value':(kanbanInstance?.charge),'class':("span12")],-1)
printHtmlPart(10)
})
invokeTag('form','g',57,['url':([resource:kanbanInstance, action:'save'])],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399041410894L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
