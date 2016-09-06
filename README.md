# Groovy Git Hooks

### Installation

1. Make sure groovy executable is available in /usr/local/bin/groovy
2. Invoke install script and point it to the target repository:
```
./install.sh /path/to/repository
```

### Hooks

#### commit-msg

Enforce two types of commit messages:
 * #123: Description
 * WIP
