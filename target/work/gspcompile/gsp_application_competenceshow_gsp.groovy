import application.MailService
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_competenceshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/competence/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)

def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()

printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
if(true && (competenceInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',64,['code':("Competence.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',64,['bean':(competenceInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (competenceInstance?.effectifs)) {
printHtmlPart(10)
for( o in (competenceInstance.effectifs) ) {
printHtmlPart(11)
invokeTag('message','g',74,['code':("competence.effectifs.label"),'default':("Effectifs associés : ")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(o?.nom.encodeAsHTML())
})
invokeTag('link','g',74,['controller':("Effectif"),'action':("show"),'id':(o.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (competenceInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',124,['code':("Competence.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',124,['bean':(competenceInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(16)
if(true && (competenceInstance?.effectifs)) {
printHtmlPart(10)
for( o in (competenceInstance.effectifs) ) {
printHtmlPart(11)
invokeTag('message','g',133,['code':("competence.effectifs.label"),'default':("Effectifs associés : ")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(o?.nom.encodeAsHTML())
})
invokeTag('link','g',133,['controller':("Effectif"),'action':("show"),'id':(o.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(17)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',152,['action':("ressource"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(19)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331535L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
