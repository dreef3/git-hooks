#!/usr/local/bin/groovy

class CommitMsg {
	static final def COMMIT_MESSAGE_REGEX = /#\d+:.+/
	static final def WIP_COMMIT_MESSAGE_REGEX = /^WIP$/
	static void main(args) {
		if (!args.length) {
			usage()
		}
		def commitMsgFile = new File(args[0])
		if (!commitMsgFile.exists()) {
			println "Commit message file not found!"
			System.exit(1)
		}
		commitMsgFile.withReader { reader ->
			String msg = reader.readLine()
			if (!(msg ==~ COMMIT_MESSAGE_REGEX || msg ==~ WIP_COMMIT_MESSAGE_REGEX)) {
				println """
Invalid commit message:
	${msg}
		
Commit message must match one of the formats below:
	#123: Description
	WIP
"""
				System.exit(1)
			}
		}
	}

	static def usage() {
		println """
Usage: commit-msg <path to the file with commit msg>
"""
		System.exit(1)
	}
}
