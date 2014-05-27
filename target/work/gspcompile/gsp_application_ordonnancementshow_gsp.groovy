import application.MailService
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_ordonnancementshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordonnancement/show.gsp" }
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
if(true && (ordonnancementInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',65,['code':("ordonnancement.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',65,['bean':(ordonnancementInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (ordonnancementInstance?.famille)) {
printHtmlPart(10)
invokeTag('message','g',73,['code':("ordonnancement.famille.label"),'default':("Famille : ")],-1)
invokeTag('fieldValue','g',73,['bean':(ordonnancementInstance),'field':("famille")],-1)
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (ordonnancementInstance?.nom)) {
printHtmlPart(7)
invokeTag('message','g',124,['code':("ordonnancement.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',124,['bean':(ordonnancementInstance),'field':("nom")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (ordonnancementInstance?.famille)) {
printHtmlPart(10)
invokeTag('message','g',132,['code':("ordonnancement.famille.label"),'default':("Famille : ")],-1)
invokeTag('fieldValue','g',132,['bean':(ordonnancementInstance),'field':("famille")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',151,['action':("activite"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(14)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043422L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
