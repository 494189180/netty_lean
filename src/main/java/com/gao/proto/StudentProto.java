// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.gao.proto;

public final class StudentProto {
    private StudentProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_com_gao_proto_MyRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_com_gao_proto_MyRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_com_gao_proto_MyResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_com_gao_proto_MyResponse_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\rStudent.proto\022\rcom.gao.proto\"\035\n\tMyRequ" +
                        "est\022\020\n\010username\030\001 \001(\t\"\036\n\nMyResponse\022\020\n\010r" +
                        "ealname\030\002 \001(\t2`\n\016StudentService\022N\n\025GetRe" +
                        "alNameByUsername\022\030.com.gao.proto.MyReque" +
                        "st\032\031.com.gao.proto.MyResponse\"\000B\037\n\rcom.g" +
                        "ao.protoB\014StudentProtoP\001b\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_com_gao_proto_MyRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_com_gao_proto_MyRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_com_gao_proto_MyRequest_descriptor,
                new String[]{"Username",});
        internal_static_com_gao_proto_MyResponse_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_com_gao_proto_MyResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_com_gao_proto_MyResponse_descriptor,
                new String[]{"Realname",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
