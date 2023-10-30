;;; Sierra Script 1.0 - (do not remove this comment)
(script# 750)
(include sci.sh)
(use Main)
(use LLRoom)
(use MCyc)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm750 0
)

(local
	[local0 29] = [0 0 183 137 0 1 220 111 0 2 258 101 0 3 287 117 0 4 319 131 0 4 340 151 0 4 360 151 -32768]
	[local29 33] = [1 0 155 137 1 1 133 115 1 2 104 102 1 3 61 108 1 4 42 119 1 5 12 141 1 5 -5 155 1 5 -35 155 -32768]
	[local62 37] = [2 0 157 143 2 1 177 101 2 2 206 73 2 3 234 54 2 4 264 49 2 5 285 41 2 5 305 35 2 5 325 25 2 5 345 15 -32768]
)
(instance rm750 of LLRoom
	(properties
		picture 750
	)
	
	(method (init)
		(Load rsSCRIPT 942)
		(proc958_0 128 753 754 752)
		(proc958_0 132 750 862 751)
		(gLarry
			init:
			x: 125
			y: 130
			view: 754
			setLoop: 0
			setCycle: 0
		)
		(super init:)
		(lana init:)
		(dyke init: stopUpd:)
		(guy1 init: stopUpd:)
		(guy2 init: stopUpd:)
		(guy3 init: stopUpd:)
		(guy4 init: stopUpd:)
		(guy5 init: stopUpd:)
		(guy6 init: stopUpd:)
		(guy7 init: stopUpd:)
		(guy8 init: stopUpd:)
		(self setScript: sCartoon)
		(proc0_2)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 123))
			(1
				(proc0_10 40 136)
				(proc0_14 750 0 67 -1 15 70 280)
				(= ticks 123)
			)
			(2
				(soundFX number: 862 flags: 1 play: guy1)
				(clothes init: setCycle: MCyc @local62 self)
			)
			(3
				(clothes hide:)
				(guy8 setCycle: End self)
			)
			(4
				(guy8 stopUpd:)
				(dyke setCycle: End self)
			)
			(5
				(dyke stopUpd:)
				(guy7 setCycle: End self)
			)
			(6
				(guy7 stopUpd:)
				(guy1 setCycle: End self)
			)
			(7
				(guy1 stopUpd:)
				(soundFX number: 862 play: guy1)
				(clothes show: setCycle: MCyc @local0 self)
			)
			(8
				(guy3 setCycle: End self)
				(clothes hide:)
			)
			(9
				(guy3 stopUpd:)
				(guy2 setCycle: End self)
			)
			(10
				(guy2 stopUpd:)
				(guy4 setCycle: End self)
			)
			(11
				(guy4 stopUpd:)
				(soundFX number: 862 play: guy1)
				(clothes show: setCycle: MCyc @local29 self)
			)
			(12
				(clothes dispose:)
				(guy5 setCycle: End self)
			)
			(13
				(guy5 stopUpd:)
				(guy6 setCycle: End self)
			)
			(14
				(guy6 stopUpd:)
				(guy7 setCycle: End self)
			)
			(15
				(guy7 stopUpd:)
				(guy8 setCycle: End self)
			)
			(16
				(guy8 stopUpd:)
				(dyke setCycle: End self)
			)
			(17
				(dyke stopUpd:)
				(gLongSong loop: 1 number: 750 play:)
				(gLarry setCycle: End self)
			)
			(18
				(gLarry stopUpd:)
				(lana setCycle: End self)
			)
			(19
				(lana stopUpd:)
				(guy1 setCycle: End self)
			)
			(20
				(guy1 stopUpd:)
				(guy3 setCycle: End self)
			)
			(21
				(guy3 stopUpd:)
				(gLarry setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
				(lana setCel: 0 setLoop: 1 setCycle: End)
			)
			(22 (= seconds 5))
			(23
				(proc0_14 750 1 67 -1 20)
				(gLarry setCycle: End self)
			)
			(24
				(gLarry setLoop: 2 setCel: 0 setCycle: End self)
				(lana setCel: 0 setLoop: 2 setCycle: End)
			)
			(25 (= ticks 123))
			(26
				(proc0_14 750 2 80 {Ty} 67 -1 15 70 280)
				(= ticks 123)
			)
			(27
				(if (>= ((Inv at: 0) state?) 100)
					(proc0_9 3)
					(proc0_10 20 137)
					(proc0_14 750 3 67 -1 15 70 280)
				else
					(proc0_14 750 4 67 -1 15 70 280)
				)
				(gLarry setLoop: 3 setCel: 0 setCycle: End)
				(= seconds 5)
			)
			(28
				(DrawPic 1 dpOPEN_EDGECENTER)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(29
				(proc0_14 750 5)
				(= seconds 3)
			)
			(30 (global2 newRoom: 700))
		)
	)
)

(instance lana of Prop
	(properties
		x 185
		y 130
		description {Lana}
		sightAngle 40
		lookStr {Jak se Lana zm�nila! Navenek to byla jen kr�sn� mlad� d�ma. Tady je z n� zv��e!}
		view 753
		signal $4000
	)
)

(instance clothes of Prop
	(properties
		x 150
		y 150
		yStep 13
		view 752
		loop 2
		signal $4000
		cycleSpeed 8
	)
)

(instance dyke of Prop
	(properties
		x 143
		y 84
		view 750
		signal $4000
	)
)

(instance guy1 of Prop
	(properties
		x 171
		y 81
		view 750
		loop 1
		signal $4000
		cycleSpeed 7
	)
	
	(method (cue)
		(super cue:)
		(soundFX number: 751 play:)
	)
)

(instance guy2 of Prop
	(properties
		x 165
		y 46
		view 750
		loop 2
		signal $4000
		cycleSpeed 8
	)
)

(instance guy3 of Prop
	(properties
		x 213
		y 45
		view 750
		loop 3
		signal $4000
		cycleSpeed 9
	)
)

(instance guy4 of Prop
	(properties
		x 85
		y 64
		view 750
		loop 4
		signal $4000
		cycleSpeed 8
	)
)

(instance guy5 of Prop
	(properties
		x 102
		y 82
		view 750
		loop 5
		signal $4000
		cycleSpeed 7
	)
)

(instance guy6 of Prop
	(properties
		x 181
		y 59
		view 750
		loop 6
		signal $4000
	)
)

(instance guy7 of Prop
	(properties
		x 13
		y 77
		view 750
		loop 7
		signal $4000
		cycleSpeed 7
	)
)

(instance guy8 of Prop
	(properties
		x 20
		y 114
		view 750
		loop 8
		signal $4000
		cycleSpeed 10
	)
)

(instance soundFX of Sound
	(properties)
)
