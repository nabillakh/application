/*
 * Copyright 2010 Grails Plugin Collective
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.jms.bean

class MapBasedBeanDefinitionBuilder {

    private name
    private definition
    
    MapBasedBeanDefinitionBuilder(name, Map definition) {
        this.name = name
        this.definition = definition
    }

    def getName() {
        name
    }
    
    def getClazz() {
        definition.clazz
    }
    
    def getMeta() {
        definition.meta
    }    

    def getProperties() {
        def properties = definition.clone()
        properties.remove('clazz')
        properties.remove('meta')
        properties
    }

    def build(beanBuilder) {
        beanBuilder.with {
            "${this.getName()}"(clazz) { metaBean ->
                def bean = delegate
                
                this.meta.each { k,v ->
                    this.set(k, v, metaBean, beanBuilder)
                }
                this.properties.each { k,v ->
                    this.set(k, v, bean, beanBuilder)
                }
            }
        }
    }
    
    def removeFrom(context) {
        def beanName = getName()
        context.containsBean(beanName) && context.removeBeanDefinition(beanName)
    }
    
    protected set(name, value, recipient, beanBuilder) {
        if (name.endsWith('Bean')) {
            recipient."${name.substring(0, name.size() - 4)}" = beanBuilder.ref(value)
        } else {
            recipient."$name" = value
        }
    }
}