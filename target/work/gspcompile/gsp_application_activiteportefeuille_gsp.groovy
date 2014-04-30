import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_activiteportefeuille_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/activite/portefeuille.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
invokeTag('render','g',11,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
loop:{
int i = 0
for( kanbanInstance in (kanbanInstanceList) ) {
printHtmlPart(6)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(7)
expressionOut.print(kanbanInstance.id)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
printHtmlPart(10)
})
invokeTag('link','g',72,['action':("show"),'controller':("kanban"),'id':(kanbanInstance.id)],2)
printHtmlPart(11)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "description"))
printHtmlPart(12)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "dateLancement"))
printHtmlPart(12)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "dateFinPlanifie"))
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
expressionOut.print(monKanban.nomKanban)
printHtmlPart(15)
expressionOut.print(monKanban.description)
printHtmlPart(16)
expressionOut.print(monKanban.famille)
printHtmlPart(17)
loop:{
int i = 0
for( famille in (familleInstanceList) ) {
printHtmlPart(18)
expressionOut.print(famille.id)
printHtmlPart(19)
expressionOut.print(famille.nom)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
expressionOut.print(monKanban.ordo)
printHtmlPart(17)
loop:{
int i = 0
for( ordo in (application.PP.Ordonnancement.list()) ) {
printHtmlPart(18)
expressionOut.print(ordo.id)
printHtmlPart(19)
expressionOut.print(ordo.nom)
printHtmlPart(20)
i++
}
}
printHtmlPart(22)
expressionOut.print(monKanban.dateFinPlanifie)
printHtmlPart(23)
expressionOut.print(monKanban.chargePlanifiee)
printHtmlPart(24)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398769597606L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
