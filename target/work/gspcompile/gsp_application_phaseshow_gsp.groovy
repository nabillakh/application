import application.MailService
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_phaseshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/phase/show.gsp" }
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
if(true && (phaseInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',64,['code':("phase.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',64,['bean':(phaseInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (phaseInstance?.cleRepartition)) {
printHtmlPart(10)
invokeTag('message','g',72,['code':("phase.cleRepartition.label"),'default':("cleRepartition : ")],-1)
invokeTag('fieldValue','g',72,['bean':(phaseInstance),'field':("cleRepartition")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (phaseInstance?.competence)) {
printHtmlPart(12)
invokeTag('message','g',80,['code':("phase.competence.label"),'default':("competence : ")],-1)
invokeTag('fieldValue','g',80,['bean':(phaseInstance),'field':("competence.nom")],-1)
printHtmlPart(8)
}
printHtmlPart(13)
if(true && (phaseInstance?.monOrdo.nom)) {
printHtmlPart(14)
invokeTag('message','g',87,['code':("phase.monOrdo.label"),'default':("monOrdo : ")],-1)
invokeTag('fieldValue','g',87,['bean':(phaseInstance),'field':("monOrdo.nom")],-1)
printHtmlPart(8)
}
printHtmlPart(15)
if(true && (phaseInstance?.kanbans)) {
printHtmlPart(16)
for( o in (phaseInstance.kanbans) ) {
printHtmlPart(17)
invokeTag('message','g',95,['code':("phase.kanbans.label"),'default':("Kanban : ")],-1)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(o?.nomKanban.encodeAsHTML())
})
invokeTag('link','g',95,['controller':("kanbans"),'action':("show"),'id':(o.id)],3)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (phaseInstance?.ordre)) {
printHtmlPart(22)
invokeTag('message','g',104,['code':("phase.ordre.label"),'default':("monOrdo : ")],-1)
invokeTag('fieldValue','g',104,['bean':(phaseInstance),'field':("ordre")],-1)
printHtmlPart(8)
}
printHtmlPart(23)
if(true && (phaseInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',154,['code':("phase.nom.label"),'default':("Nom : ")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (phaseInstance?.cleRepartition)) {
printHtmlPart(10)
invokeTag('message','g',162,['code':("phase.cleRepartition.label"),'default':("cleRepartition : ")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (phaseInstance?.competence)) {
printHtmlPart(12)
invokeTag('message','g',170,['code':("phase.competence.label"),'default':("competence : ")],-1)
printHtmlPart(8)
}
printHtmlPart(13)
if(true && (phaseInstance?.monOrdo.nom)) {
printHtmlPart(14)
invokeTag('message','g',177,['code':("phase.monOrdo.label"),'default':("monOrdo : ")],-1)
printHtmlPart(8)
}
printHtmlPart(15)
if(true && (phaseInstance?.kanbans)) {
printHtmlPart(16)
for( o in (phaseInstance.kanbans) ) {
printHtmlPart(17)
invokeTag('message','g',185,['code':("phasekanbans.label"),'default':("Kanban : ")],-1)
printHtmlPart(18)
invokeTag('link','g',185,['controller':("kanbans"),'action':("show"),'id':(o.id)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (phaseInstance?.ordre)) {
printHtmlPart(22)
invokeTag('message','g',194,['code':("phase.ordre.label"),'default':("monOrdo : ")],-1)
printHtmlPart(8)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',212,['action':("activite"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(26)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043436L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
