import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_administrationressource_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/administration/ressource.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
invokeTag('render','g',10,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
loop:{
int i = 0
for( EffectifInstance in (effectifInstanceList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: EffectifInstance, field: "nom"))
})
invokeTag('link','g',118,['action':("show"),'controller':("Effectif"),'id':(EffectifInstance.id)],2)
printHtmlPart(12)
expressionOut.print(EffectifInstance.prenom)
printHtmlPart(12)
expressionOut.print(EffectifInstance.equipe)
printHtmlPart(12)
expressionOut.print(EffectifInstance.accountExpired)
printHtmlPart(12)
expressionOut.print(EffectifInstance.accountLocked)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
loop:{
int i = 0
for( competenceInstance in (competenceInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: competenceInstance, field: "nom"))
})
invokeTag('link','g',175,['action':("show"),'controller':("Competence"),'id':(competenceInstance.id)],2)
printHtmlPart(17)
expressionOut.print(competenceInstance.effectifs.size())
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
loop:{
int i = 0
for( droitInstance in (droitInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: droitInstance, field: "authority"))
})
invokeTag('link','g',207,['action':("show"),'controller':("Droit"),'id':(droitInstance.id)],2)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('render','g',238,['template':("/menues/mainright")],-1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399041410851L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
