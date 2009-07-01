--
-- create synonyms CMS_HLTDEV.TableName -> TableName
--

CREATE OR REPLACE SYNONYM SuperIdReleaseAssoc 		FOR CMS_HLTDEV.SuperIdReleaseAssoc; 	
CREATE OR REPLACE SYNONYM SoftwareReleases 		FOR CMS_HLTDEV.SoftwareReleases;		
CREATE OR REPLACE SYNONYM SoftwareSubsystems 		FOR CMS_HLTDEV.SoftwareSubsystems;
CREATE OR REPLACE SYNONYM SoftwarePackages 		FOR CMS_HLTDEV.SoftwarePackages;
CREATE OR REPLACE SYNONYM ConfigurationPathAssoc 	FOR CMS_HLTDEV.ConfigurationPathAssoc; 	
CREATE OR REPLACE SYNONYM StreamPathAssoc	 	FOR CMS_HLTDEV.StreamPathAssoc; 	
CREATE OR REPLACE SYNONYM ConfigurationStreamAssoc	FOR CMS_HLTDEV.ConfigurationStreamAssoc;
CREATE OR REPLACE SYNONYM PrimaryDatasetPathAssoc	FOR CMS_HLTDEV.PrimaryDatasetPathAssoc;
CREATE OR REPLACE SYNONYM PathInPathAssoc 		FOR CMS_HLTDEV.PathInPathAssoc; 		
CREATE OR REPLACE SYNONYM PathModuleAssoc 		FOR CMS_HLTDEV.PathModuleAssoc; 		 
CREATE OR REPLACE SYNONYM ConfigurationSequenceAssoc 	FOR CMS_HLTDEV.ConfigurationSequenceAssoc;
CREATE OR REPLACE SYNONYM PathSequenceAssoc 		FOR CMS_HLTDEV.PathSequenceAssoc; 	
CREATE OR REPLACE SYNONYM SequenceInSequenceAssoc 	FOR CMS_HLTDEV.SequenceInSequenceAssoc;
CREATE OR REPLACE SYNONYM SequenceModuleAssoc 		FOR CMS_HLTDEV.SequenceModuleAssoc;
CREATE OR REPLACE SYNONYM ConfigurationServiceAssoc 	FOR CMS_HLTDEV.ConfigurationServiceAssoc;
CREATE OR REPLACE SYNONYM ConfigurationEDSourceAssoc 	FOR CMS_HLTDEV.ConfigurationEDSourceAssoc;
CREATE OR REPLACE SYNONYM ConfigurationESSourceAssoc 	FOR CMS_HLTDEV.ConfigurationESSourceAssoc;
CREATE OR REPLACE SYNONYM ConfigurationESModuleAssoc 	FOR CMS_HLTDEV.ConfigurationESModuleAssoc;
CREATE OR REPLACE SYNONYM ConfigurationParamSetAssoc 	FOR CMS_HLTDEV.ConfigurationParamSetAssoc;
CREATE OR REPLACE SYNONYM Paths 			FOR CMS_HLTDEV.Paths;
CREATE OR REPLACE SYNONYM Sequences 			FOR CMS_HLTDEV.Sequences;
CREATE OR REPLACE SYNONYM Services 			FOR CMS_HLTDEV.Services;
CREATE OR REPLACE SYNONYM ServiceTemplates 		FOR CMS_HLTDEV.ServiceTemplates;
CREATE OR REPLACE SYNONYM EDSources 			FOR CMS_HLTDEV.EDSources;
CREATE OR REPLACE SYNONYM EDSourceTemplates 		FOR CMS_HLTDEV.EDSourceTemplates;
CREATE OR REPLACE SYNONYM ESSources 			FOR CMS_HLTDEV.ESSources;
CREATE OR REPLACE SYNONYM ESSourceTemplates 		FOR CMS_HLTDEV.ESSourceTemplates;
CREATE OR REPLACE SYNONYM ESModules 			FOR CMS_HLTDEV.ESModules;
CREATE OR REPLACE SYNONYM ESModuleTemplates 		FOR CMS_HLTDEV.ESModuleTemplates;
CREATE OR REPLACE SYNONYM Modules 			FOR CMS_HLTDEV.Modules;
CREATE OR REPLACE SYNONYM ModuleTemplates		FOR CMS_HLTDEV.ModuleTemplates;
CREATE OR REPLACE SYNONYM ModuleTypes 			FOR CMS_HLTDEV.ModuleTypes;
CREATE OR REPLACE SYNONYM Configurations 		FOR CMS_HLTDEV.Configurations;
CREATE OR REPLACE SYNONYM LockedConfigurations		FOR CMS_HLTDEV.LockedConfigurations;
CREATE OR REPLACE SYNONYM Streams	 		FOR CMS_HLTDEV.Streams;
CREATE OR REPLACE SYNONYM PrimaryDatasets 		FOR CMS_HLTDEV.PrimaryDatasets;
CREATE OR REPLACE SYNONYM Directories 			FOR CMS_HLTDEV.Directories;
CREATE OR REPLACE SYNONYM Int32ParamValues 		FOR CMS_HLTDEV.Int32ParamValues;
CREATE OR REPLACE SYNONYM VInt32ParamValues 		FOR CMS_HLTDEV.VInt32ParamValues;
CREATE OR REPLACE SYNONYM UInt32ParamValues 		FOR CMS_HLTDEV.UInt32ParamValues;
CREATE OR REPLACE SYNONYM VUInt32ParamValues 		FOR CMS_HLTDEV.VUInt32ParamValues;
CREATE OR REPLACE SYNONYM Int64ParamValues 		FOR CMS_HLTDEV.Int64ParamValues;
CREATE OR REPLACE SYNONYM VInt64ParamValues 		FOR CMS_HLTDEV.VInt64ParamValues;
CREATE OR REPLACE SYNONYM UInt64ParamValues 		FOR CMS_HLTDEV.UInt64ParamValues;
CREATE OR REPLACE SYNONYM VUInt64ParamValues 		FOR CMS_HLTDEV.VUInt64ParamValues;
CREATE OR REPLACE SYNONYM BoolParamValues 		FOR CMS_HLTDEV.BoolParamValues;
CREATE OR REPLACE SYNONYM DoubleParamValues	 	FOR CMS_HLTDEV.DoubleParamValues;
CREATE OR REPLACE SYNONYM VDoubleParamValues 		FOR CMS_HLTDEV.VDoubleParamValues;
CREATE OR REPLACE SYNONYM StringParamValues 		FOR CMS_HLTDEV.StringParamValues;
CREATE OR REPLACE SYNONYM VStringParamValues	 	FOR CMS_HLTDEV.VStringParamValues;
CREATE OR REPLACE SYNONYM InputTagParamValues 		FOR CMS_HLTDEV.InputTagParamValues;
CREATE OR REPLACE SYNONYM VInputTagParamValues 		FOR CMS_HLTDEV.VInputTagParamValues;
CREATE OR REPLACE SYNONYM EventIDParamValues 		FOR CMS_HLTDEV.EventIDParamValues;
CREATE OR REPLACE SYNONYM VEventIDParamValues 		FOR CMS_HLTDEV.VEventIDParamValues;
CREATE OR REPLACE SYNONYM FileInPathParamValues 	FOR CMS_HLTDEV.FileInPathParamValues;
CREATE OR REPLACE SYNONYM SuperIdParameterAssoc 	FOR CMS_HLTDEV.SuperIdParameterAssoc;
CREATE OR REPLACE SYNONYM SuperIdParamSetAssoc 		FOR CMS_HLTDEV.SuperIdParamSetAssoc;
CREATE OR REPLACE SYNONYM SuperIdVecParamSetAssoc 	FOR CMS_HLTDEV.SuperIdVecParamSetAssoc;
CREATE OR REPLACE SYNONYM ParameterSets 		FOR CMS_HLTDEV.ParameterSets;
CREATE OR REPLACE SYNONYM VecParameterSets 		FOR CMS_HLTDEV.VecParameterSets;
CREATE OR REPLACE SYNONYM Parameters 			FOR CMS_HLTDEV.Parameters;
CREATE OR REPLACE SYNONYM SuperIds 			FOR CMS_HLTDEV.SuperIds;
CREATE OR REPLACE SYNONYM ParameterTypes 		FOR CMS_HLTDEV.ParameterTypes;

CREATE OR REPLACE SYNONYM ReleaseId_Sequence 		FOR CMS_HLTDEV.ReleaseId_Sequence;
CREATE OR REPLACE SYNONYM SubsysId_Sequence 		FOR CMS_HLTDEV.SubsysId_Sequence;
CREATE OR REPLACE SYNONYM PackageId_Sequence 		FOR CMS_HLTDEV.PackageId_Sequence;
CREATE OR REPLACE SYNONYM DirId_Sequence 		FOR CMS_HLTDEV.DirId_Sequence;
CREATE OR REPLACE SYNONYM ConfigId_Sequence 		FOR CMS_HLTDEV.ConfigId_Sequence;
CREATE OR REPLACE SYNONYM StreamId_Sequence 		FOR CMS_HLTDEV.StreamId_Sequence;
CREATE OR REPLACE SYNONYM DatasetId_Sequence 		FOR CMS_HLTDEV.DatasetId_Sequence;
CREATE OR REPLACE SYNONYM SuperId_Sequence 		FOR CMS_HLTDEV.SuperId_Sequence;
CREATE OR REPLACE SYNONYM PathId_Sequence 		FOR CMS_HLTDEV.PathId_Sequence;
CREATE OR REPLACE SYNONYM SequenceId_Sequence 		FOR CMS_HLTDEV.SequenceId_Sequence;
CREATE OR REPLACE SYNONYM ParamId_Sequence 		FOR CMS_HLTDEV.ParamId_Sequence;

CREATE OR REPLACE SYNONYM load_parameter_value          FOR CMS_HLTDEV.load_parameter_value;
CREATE OR REPLACE SYNONYM load_parameters               FOR CMS_HLTDEV.load_parameters;
CREATE OR REPLACE SYNONYM load_template                 FOR CMS_HLTDEV.load_template;
CREATE OR REPLACE SYNONYM load_templates                FOR CMS_HLTDEV.load_templates;
CREATE OR REPLACE SYNONYM load_templates_for_config     FOR CMS_HLTDEV.load_templates_for_config;
CREATE OR REPLACE SYNONYM load_configuration            FOR CMS_HLTDEV.load_configuration;
CREATE OR REPLACE SYNONYM get_parameters                FOR CMS_HLTDEV.get_parameters; 
CREATE OR REPLACE SYNONYM get_boolean_values            FOR CMS_HLTDEV.get_boolean_values;
CREATE OR REPLACE SYNONYM get_int_values                FOR CMS_HLTDEV.get_int_values;
CREATE OR REPLACE SYNONYM get_real_values               FOR CMS_HLTDEV.get_real_values;
CREATE OR REPLACE SYNONYM get_string_values             FOR CMS_HLTDEV.get_string_values;
CREATE OR REPLACE SYNONYM get_path_entries              FOR CMS_HLTDEV.get_path_entries;
CREATE OR REPLACE SYNONYM get_sequence_entries          FOR CMS_HLTDEV.get_sequence_entries;

CREATE OR REPLACE SYNONYM types                         FOR CMS_HLTDEV.types;

CREATE OR REPLACE SYNONYM tmp_template_table            FOR CMS_HLTDEV.tmp_template_table;
CREATE OR REPLACE SYNONYM tmp_instance_table            FOR CMS_HLTDEV.tmp_instance_table;
CREATE OR REPLACE SYNONYM tmp_parameter_table           FOR CMS_HLTDEV.tmp_parameter_table;
CREATE OR REPLACE SYNONYM tmp_boolean_table             FOR CMS_HLTDEV.tmp_boolean_table;
CREATE OR REPLACE SYNONYM tmp_int_table                 FOR CMS_HLTDEV.tmp_int_table;
CREATE OR REPLACE SYNONYM tmp_real_table                FOR CMS_HLTDEV.tmp_real_table;
CREATE OR REPLACE SYNONYM tmp_string_table              FOR CMS_HLTDEV.tmp_string_table;
CREATE OR REPLACE SYNONYM tmp_path_entries              FOR CMS_HLTDEV.tmp_path_entries;
CREATE OR REPLACE SYNONYM tmp_sequence_entries          FOR CMS_HLTDEV.tmp_sequence_entries;
