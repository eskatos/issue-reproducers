
// This extension is absent
// We should not get a deprecation warning about accessing conventions
the<SourceDirectorySet>()

// Problem is the same with
// the(SourceDirectorySet::class)
// configure<SourceDirectorySet> {}
