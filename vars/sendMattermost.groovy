import hudson.model.Result
import org.jenkinsci.plugins.workflow.support.steps.build.RunWrapper


/**
 * Mattermost plugin helper for sending automatic build status Mattermost
 * notifications under two circumstances: (1) when a build fails or is
 * unstable (2) when a previously-unstable/failed build now succeeds
 * (_ie_ is fixed).
 *
 * @param currentBuild a Jenkins RunWrapper object for the current build
 * @param channel a string; Mattermost channel receiving notifications
 * @param endpoint a string; Mattermost url endpoint containing webhook token
 */

def call(RunWrapper currentBuild, String channel, String endpoint) {

    def currentResult = currentBuild.result
    def previousResult = currentBuild.getPreviousBuild()?.result

    def buildIsFixed =
        currentResult == Result.SUCCESS.toString() &&
        currentResult != previousResult &&
        previousResult != null

    if (buildIsFixed) {
        buildStatus = 'FIXED'
    } else {
        buildStatus = currentResult.result
    }

    def badResult =
        currentResult in [Result.UNSTABLE.toString(), Result.FAILURE.toString()]

    if (buildIsFixed || badResult) {
        String notifyMessage = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
        notifyMessage += "\n${env.BUILD_URL}"
        mattermostSend (
            channel: channel,
            message: notifyMessage,
            endpoint: endpoint
        )
    }
}
