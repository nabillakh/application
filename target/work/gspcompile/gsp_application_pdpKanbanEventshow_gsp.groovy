import application.pilotage.PdpKanbanEvent
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_pdpKanbanEventshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pdpKanbanEvent/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'pdpKanbanEvent.label', default: 'PdpKanbanEvent'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (pdpKanbanEventInstance?.imputations)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("pdpKanbanEvent.imputations.label"),'default':("Imputations")],-1)
printHtmlPart(15)
for( i in (pdpKanbanEventInstance.imputations) ) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(i?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("event"),'action':("show"),'id':(i.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (pdpKanbanEventInstance?.kanban)) {
printHtmlPart(20)
invokeTag('message','g',39,['code':("pdpKanbanEvent.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(pdpKanbanEventInstance?.kanban?.encodeAsHTML())
})
invokeTag('link','g',41,['controller':("kanban"),'action':("show"),'id':(pdpKanbanEventInstance?.kanban?.id)],3)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (pdpKanbanEventInstance?.kanbanReel)) {
printHtmlPart(23)
invokeTag('message','g',48,['code':("pdpKanbanEvent.kanbanReel.label"),'default':("Kanban Reel")],-1)
printHtmlPart(24)
invokeTag('formatBoolean','g',50,['boolean':(pdpKanbanEventInstance?.kanbanReel)],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (pdpKanbanEventInstance?.pdp)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("pdpKanbanEvent.pdp.label"),'default':("Pdp")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(pdpKanbanEventInstance?.pdp?.encodeAsHTML())
})
invokeTag('link','g',59,['controller':("pdp"),'action':("show"),'id':(pdpKanbanEventInstance?.pdp?.id)],3)
printHtmlPart(22)
}
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',67,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',67,['class':("edit"),'action':("edit"),'resource':(pdpKanbanEventInstance)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',68,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',70,['url':([resource:pdpKanbanEventInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331689L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
