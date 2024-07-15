#!/bin/bash

unalias -a

# executes first time only
if [ "$_already_run" != 1 ]; then 
    export base_dir=`pwd`
fi
export _already_run=1
alias config_bash=". $base_dir/bash_config.sh"
export bash_config="$base_dir/bash_config.sh"

alias run="javac engine/Run.java; java engine.Run false"
alias debug="javac engine/Run.java; java engine.Run true"

# variable that stores classpath
export _temp_CLASSPATH=".:$base_dir/libs"

# aliases
alias javac="javac -classpath $_temp_CLASSPATH"
alias java="java -classpath $_temp_CLASSPATH"
alias jdb="jdb -sourcepath $_temp_CLASSPATH"

echo success