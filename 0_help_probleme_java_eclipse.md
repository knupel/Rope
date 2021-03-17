Sometime a part of this code is lost and eclipse don't reconize it.
So look if the
<buildSpec>
	<buildCommand>
		<name>org.eclipse.jdt.core.javabuilder</name>
		<arguments>
		</arguments>
	</buildCommand>
</buildSpec>

and is présent
<natures>
	<nature>org.eclipse.jdt.core.javanature</nature>
</nature>


The last original 
2021 / 3 /17
is like that

<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>Rope</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
	<filteredResources>
		<filter>
			<id>1612020793752</id>
			<name></name>
			<type>30</type>
			<matcher>
				<id>org.eclipse.core.resources.regexFilterMatcher</id>
				<arguments>node_modules|.git|__CREATED_BY_JAVA_LANGUAGE_SERVER__</arguments>
			</matcher>
		</filter>
	</filteredResources>
</projectDescription>