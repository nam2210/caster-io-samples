package info.adavis.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

@SuppressWarnings("GroovyUnusedDeclaration")
public class BumpVersion extends DefaultTask {

    def readMe
    def versionName

    File getReadMe() {
        project.file(readMe)
    }

    BumpVersion() {
        group = 'pluginInt'
    }

    @TaskAction
    def bump() {
        description = 'Updates ReadMe file with the latest version'

        File readMeFile = getReadMe()
        String contents = readMeFile.getText('UTF-8')
        contents = contents.replaceAll("plugin:.*", "plugin:${versionName}")
        readMeFile.write(contents, 'UTF-8')
    }

}